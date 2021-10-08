package com.example.studentdemo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String student(@RequestParam(name="name", required=false, defaultValue="name") String name,
                          @RequestParam(name="age", required = false, defaultValue = "0") int age,
                          @RequestParam(name="ID", required = false, defaultValue = "0") long ID, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("ID", ID);
        return "student";
    }

}
