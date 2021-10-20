package com.example.formHandling;

import javax.validation.constraints.*;

public class Student {
    @NotNull
    @Size(min=2,max=30)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    @NotNull
    @Size(min = 2)
    private Integer ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}
