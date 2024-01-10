package hr.fer.aggregatormicroservice.service;


import hr.fer.aggregatormicroservice.model.DTO.ReadingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AggregatorService {

    private final TemperatureConverterService temperatureConverterService;

    private final RestTemplate restTemplate;

    public List<ReadingDTO> getAggregatedReadings() {

        String humidityUrl = "http://HUMIDITY-MICROSERVICE/api/humidity";
        String temperatureUrl = "http://TEMPERATURE-MICROSERVICE/api/temperature";

        ReadingDTO temperatureReading = restTemplate.getForObject(temperatureUrl, ReadingDTO.class);
        assert temperatureReading != null;
        Double convertedTemperature = temperatureConverterService.celsiusToKelvinConverter(temperatureReading.getValue());  // convert temperature K-C
        if (!convertedTemperature.equals(temperatureReading.getValue())) {
            temperatureReading.setUnit("K");
            temperatureReading.setValue(convertedTemperature);
        }

        ReadingDTO humidityReading = restTemplate.getForObject(humidityUrl, ReadingDTO.class);

        if (humidityReading != null) {
            List<ReadingDTO> aggregatedReadings = new ArrayList<>();
            aggregatedReadings.add(humidityReading);
            aggregatedReadings.add(temperatureReading);
            return aggregatedReadings;
        } else {
            throw new IllegalStateException("Failed to retrieve humidity and temperature readings from microservices.");
        }
    }

}
