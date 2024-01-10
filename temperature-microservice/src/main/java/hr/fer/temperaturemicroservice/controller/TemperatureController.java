package hr.fer.temperaturemicroservice.controller;

import hr.fer.temperaturemicroservice.model.DTO.TemperatureReadingDTO;
import hr.fer.temperaturemicroservice.service.TemperatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/temperature")
public class TemperatureController {

    private final TemperatureService humidityService;

    @GetMapping()
    public ResponseEntity<TemperatureReadingDTO> getHumidityReading() {
        TemperatureReadingDTO reading = humidityService.getReading();
        if(reading != null) return ResponseEntity.ok(reading);
        else return ResponseEntity.noContent().build();
    }

}
