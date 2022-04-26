package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {

    @NotNull
    private Integer id;

    @NotBlank
    private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
