package com.example.RESTService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(RestServiceApplication.class, args);
		int i = 1;
		for (String bean : ac.getBeanDefinitionNames()) {
			System.out.println(i + ". " + bean);
			++i;
			System.out.println(ac.isSingleton(bean) ? "Yes" : "No");
		}
	}

}
