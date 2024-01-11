package hr.fer.humiditymicroservice;

import hr.fer.humiditymicroservice.service.HumidityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

@EnableDiscoveryClient
@SpringBootApplication
public class HumidityMicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(HumidityMicroserviceApplication.class, args);

	}

	@Bean
	public CommandLineRunner loadData(HumidityService humidityService) {
		return args -> {
			InputStream inputStream = HumidityMicroserviceApplication.class.getResourceAsStream("/data/readings.csv");

			if (inputStream == null) {
				throw new RuntimeException("Resource not found: /data/readings.csv");
			}

			humidityService.saveHumidityReadingsFromCSV(inputStream);
		};
	}


	/*@Bean
	public CommandLineRunner loadData(HumidityService humidityService) {
		return args -> {
			String filePath = Objects.requireNonNull(HumidityMicroserviceApplication.class.getResource("/data/readings.csv")).getPath();
			humidityService.saveHumidityReadingsFromCSV(filePath);
		};
	}*/

}
