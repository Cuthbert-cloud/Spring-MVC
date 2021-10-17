package com.example.RESTService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class StudentController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/student")
    public @ResponseBody Student student(@RequestParam(value = "name", defaultValue = "student") String name,
                                         @RequestParam(value = "age", defaultValue = "0") Integer age) {
        return new Student(name, age, counter.incrementAndGet());
    }
    /*@RequestMapping("/")
    public @ResponseBody String student() {
        return "Hello, student";
    }*/
}
