package com.example.b2c_integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class B2cIntegrationApplicationTests {

	@Test
	void contextLoads() {
	}

}
