package hr.fer.aggregatormicroservice.controller;

import hr.fer.aggregatormicroservice.model.DTO.ReadingDTO;
import hr.fer.aggregatormicroservice.service.AggregatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aggregator")
public class AggregatorController {

    private final AggregatorService aggregationService;

    @GetMapping()
    public ResponseEntity<List<ReadingDTO>> getAggregatedReadings() {
        List<ReadingDTO> aggregatedReadings = aggregationService.getAggregatedReadings();
        return ResponseEntity.ok(aggregatedReadings);
    }

}
