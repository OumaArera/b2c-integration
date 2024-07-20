package com.example.b2c_integration;

import org.springframework.boot.SpringApplication;

public class TestB2cIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.from(B2cIntegrationApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
