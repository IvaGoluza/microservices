package hr.fer.aggregatormicroservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AggregatorMicroserviceApplicationTests {

	@BeforeAll
	public static void setup() {
		System.setProperty("spring.cloud.config.failFast", "false");
	}

	@Test
	void contextLoads() {
	}

}
