package hr.fer.temperaturemicroservice.service;

import hr.fer.temperaturemicroservice.model.DTO.TemperatureReadingDTO;
import hr.fer.temperaturemicroservice.model.TemperatureReading;
import hr.fer.temperaturemicroservice.repository.TemperatureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TemperatureService {

    private final TemperatureRepository temperatureRepository;
    public TemperatureReadingDTO getReading() {
        Long rowID = (((System.currentTimeMillis() / 60000) % 100) + 1);   // generate current reading
        Optional<TemperatureReading> reading = temperatureRepository.findById(rowID);
        if(reading.isPresent()) return new TemperatureReadingDTO("Temperature", "C", reading.get().getTemperature());
        else throw new EntityNotFoundException("Temperature reading with id: " + rowID + " not found.");
    }

    public void saveTemperatureReadingsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean header = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!header) {
                    header = true;
                    continue;
                }
                int temperature = Integer.parseInt(data[0]);

                TemperatureReading temperatureReading = new TemperatureReading();
                temperatureReading.setTemperature(temperature);
                temperatureRepository.save(temperatureReading);  // save all the temperature data into DB
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
