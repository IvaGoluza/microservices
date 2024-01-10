package hr.fer.temperaturemicroservice.repository;

import hr.fer.temperaturemicroservice.model.TemperatureReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<TemperatureReading, Long> {

}
