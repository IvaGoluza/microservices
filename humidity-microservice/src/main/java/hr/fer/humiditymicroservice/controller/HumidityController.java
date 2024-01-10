package hr.fer.humiditymicroservice.controller;

import hr.fer.humiditymicroservice.model.DTO.HumidityReadingDTO;
import hr.fer.humiditymicroservice.service.HumidityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/humidity")
public class HumidityController {

    private final HumidityService humidityService;

    @GetMapping()
    public ResponseEntity<HumidityReadingDTO> getHumidityReading() {
        HumidityReadingDTO reading = humidityService.getReading();
        if(reading != null) return ResponseEntity.ok(reading);
        else return ResponseEntity.noContent().build();
    }
}
