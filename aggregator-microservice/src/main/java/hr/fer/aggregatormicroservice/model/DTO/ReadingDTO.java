package hr.fer.aggregatormicroservice.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReadingDTO {

    private String name;

    private String unit;

    private Double value;

}
