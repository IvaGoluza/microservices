package hr.fer.aggregatormicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TemperatureConverterService {

    @Value("${temperature.unit}")
    private String temperatureUnit;

    public double celsiusToKelvinConverter(double celsius) {
        if (temperatureUnit.equalsIgnoreCase("K")) {
            return celsius + 273.15;
        } else {
            return celsius;
        }
    }

}
