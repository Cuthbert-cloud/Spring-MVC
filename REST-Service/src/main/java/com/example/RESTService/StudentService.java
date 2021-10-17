package com.example.RESTService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {

    private final AtomicLong counter = new AtomicLong();
    
    public String student(@RequestParam String name, @RequestParam int age) {
        return String.format("""
                {"name":%s,"age":%s,"id":%s}""",name,age,counter.incrementAndGet());
    }
}
