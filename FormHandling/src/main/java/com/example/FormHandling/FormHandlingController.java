package com.example.FormHandling;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormHandlingController {

    @GetMapping("/student")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/student")
    public String greetingSubmit(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        return "result";
    }

}
