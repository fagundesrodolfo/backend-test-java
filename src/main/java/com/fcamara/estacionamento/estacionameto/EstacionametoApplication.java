package com.fcamara.estacionamento.estacionameto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class EstacionametoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionametoApplication.class, args);
	}

}
