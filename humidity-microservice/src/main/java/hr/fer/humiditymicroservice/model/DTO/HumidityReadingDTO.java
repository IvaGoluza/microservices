package hr.fer.humiditymicroservice.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HumidityReadingDTO {

    private String name;

    private String unit;

    private Integer value;

}
