package hr.fer.humiditymicroservice;

import hr.fer.humiditymicroservice.service.HumidityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@SpringBootApplication
public class HumidityMicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(HumidityMicroserviceApplication.class, args);

	}

	@Bean
	public CommandLineRunner loadData(HumidityService humidityService) {
		return args -> {
			String filePath = Objects.requireNonNull(HumidityMicroserviceApplication.class.getResource("/data/readings.csv")).getPath();
			humidityService.saveHumidityReadingsFromCSV(filePath);
		};
	}

}
