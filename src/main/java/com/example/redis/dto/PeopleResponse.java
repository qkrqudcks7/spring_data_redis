package com.example.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PeopleResponse implements Serializable {

    private Long id;

    private String name;

    private int age;

    private String sex;
}
