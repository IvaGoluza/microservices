package hr.fer.humiditymicroservice.repository;


import hr.fer.humiditymicroservice.model.HumidityReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumidityRepository extends JpaRepository<HumidityReading, Long> {

}
