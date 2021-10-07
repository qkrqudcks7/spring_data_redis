package com.example.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class People {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int age;

    private String sex;
}
