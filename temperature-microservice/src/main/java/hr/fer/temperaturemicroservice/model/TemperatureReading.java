package hr.fer.temperaturemicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "READINGS")
public class TemperatureReading {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private Integer temperature;

}
