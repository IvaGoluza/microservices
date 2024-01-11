package hr.fer.humiditymicroservice.service;

import hr.fer.humiditymicroservice.model.DTO.HumidityReadingDTO;
import hr.fer.humiditymicroservice.model.HumidityReading;
import hr.fer.humiditymicroservice.repository.HumidityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HumidityService {

    private final HumidityRepository humidityRepository;
    public HumidityReadingDTO getReading() {
        Long rowID = (((System.currentTimeMillis() / 60000) % 100) + 1);   // generate current reading
        Optional<HumidityReading> reading = humidityRepository.findById(rowID);
        if(reading.isPresent()) return new HumidityReadingDTO("Humidity", "%", reading.get().getHumidity());
        else throw new EntityNotFoundException("Humidity reading with id: " + rowID + " not found.");
    }

    /*
    public void saveHumidityReadingsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean header = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!header) {
                    header = true;
                    continue;
                }
                int humidity = Integer.parseInt(data[2]);

                HumidityReading humidityReading = new HumidityReading();
                humidityReading.setHumidity(humidity);
                humidityRepository.save(humidityReading);  // save all the humidity data into DB
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } */

    public void saveHumidityReadingsFromCSV(InputStream inputStream) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            boolean header = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!header) {
                    header = true;
                    continue;
                }
                int humidity = Integer.parseInt(data[2]);

                HumidityReading humidityReading = new HumidityReading();
                humidityReading.setHumidity(humidity);
                humidityRepository.save(humidityReading);  // save all the humidity data into DB
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
