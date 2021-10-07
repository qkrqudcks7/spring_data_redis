package com.example.redis.controller;

import com.example.redis.domain.People;
import com.example.redis.dto.PeopleResponse;
import com.example.redis.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleRepository peopleRepository;

    @Cacheable(value = "post-single",cacheManager = "cacheManager")
    @GetMapping("/all")
    public ResponseEntity<?> all() {
        List<People> all = peopleRepository.findAll();
        List<PeopleResponse> collect = all.stream().map(people -> new PeopleResponse(people.getId(), people.getName(), people.getAge(), people.getSex())).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

    @Cacheable(value = "post-single", key = "#id",cacheManager = "cacheManager")
    @GetMapping("/one/{id}")
    public ResponseEntity<?> one(@PathVariable Long id) {
        People people = peopleRepository.findById(id).get();
        PeopleResponse peopleResponse = new PeopleResponse(people.getId(),people.getName(),people.getAge(),people.getSex());

        return ResponseEntity.ok(peopleResponse);
    }
}
