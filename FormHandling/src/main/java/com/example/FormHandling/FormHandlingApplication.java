package com.example.FormHandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FormHandlingApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(FormHandlingApplication.class, args);
		int i = 1;
		for (String bean : ac.getBeanDefinitionNames()) {
			System.out.println(i + ". " + bean);
			++i;
			System.out.println(ac.isSingleton(bean) ? "Yes" : "No");
		}
	}

}
