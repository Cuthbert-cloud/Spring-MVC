package com.example.formHandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormHandlingApplication.class, args);
		int i = 1;
		for (String bean : ac.getBeanDefinitionNames()) {
			System.out.println(i + ". " + bean);
			++i;
			System.out.println(ac.isSingleton(bean) ? "Yes" : "No");
		}
	}

}
