package com.example.RESTService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StudentController {

    private static final String templateA = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/student")
    public Student student(@RequestParam(value = "name", defaultValue = "World!") String name,
                           @RequestParam(value = "age", defaultValue = "0") Integer age) {
        return new Student(String.format(templateA, name), age, counter.incrementAndGet());
    }
}
