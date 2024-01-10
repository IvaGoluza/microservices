package hr.fer.temperaturemicroservice;

import hr.fer.temperaturemicroservice.service.TemperatureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@SpringBootApplication
public class TemperatureMicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TemperatureMicroserviceApplication.class, args);

	}

	@Bean
	public CommandLineRunner loadData(TemperatureService temperatureService) {
		return args -> {
			String filePath = Objects.requireNonNull(TemperatureMicroserviceApplication.class.getResource("/data/readings.csv")).getPath();
			temperatureService.saveTemperatureReadingsFromCSV(filePath);
		};
	}

}
