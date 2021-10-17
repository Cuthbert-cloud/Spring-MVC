package com.example.RESTService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private final StudentService service;
    private String name;
    private int age;

    public HomeController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/student")
    public @ResponseBody String student() {
        return service.student(name,age);
    }
}
