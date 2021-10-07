package com.company.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	//@GetMapping("/Spring")
	@RequestMapping(value="/Spring",method=RequestMethod.POST)
	public String welcomeSpring() {
		return "Spring Framework";
	}

	//@GetMapping("/maths")
	@RequestMapping("/maths")
	public int maths(@RequestParam(value = "first", defaultValue = "0") int num1, @RequestParam(value = "second", defaultValue = "0") int num2) {
		return num1+num2;
	}
}
