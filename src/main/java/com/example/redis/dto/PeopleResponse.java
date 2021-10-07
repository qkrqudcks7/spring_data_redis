package com.example.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeopleResponse {

    private Long id;

    private String name;

    private int age;

    private String sex;
}
