package hr.fer.humiditymicroservice.model;

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
public class HumidityReading {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private Integer humidity;

}
