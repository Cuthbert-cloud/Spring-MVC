package com.example.StudentApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String studentForm(@RequestParam(name="name", required=false, defaultValue="name") String name,
                              @RequestParam(name="age", required = false,defaultValue = "0") int age,
                              @RequestParam(name = "ID", required = false,defaultValue = "0") long id, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("ID", id);
        return "student";
    }

    /*@PostMapping("/student")
    public String studentSubmit(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        return "result";
    }*/
}
