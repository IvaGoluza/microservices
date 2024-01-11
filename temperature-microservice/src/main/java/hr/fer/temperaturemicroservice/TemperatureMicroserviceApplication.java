package hr.fer.temperaturemicroservice;

import hr.fer.temperaturemicroservice.service.TemperatureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

@EnableDiscoveryClient
@SpringBootApplication
public class TemperatureMicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TemperatureMicroserviceApplication.class, args);

	}

	@Bean
	public CommandLineRunner loadData(TemperatureService temperatureService) {
		return args -> {
			InputStream inputStream = TemperatureMicroserviceApplication.class.getResourceAsStream("/data/readings.csv");
			if (inputStream == null) {
				throw new RuntimeException("Resource not found: /data/readings.csv");
			}
			temperatureService.saveTemperatureReadingsFromCSV(inputStream);
		};
	}

}
