package com.example.RESTService;

public class Student {
    private String name;
    private Integer age;
    private long ID;

    public Student(String name, Integer age, long ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public long getID() {
        return ID;
    }
}
