package pl.sda.travel360.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class WeatherDto {

    private String city;
    private String currentTemperature;

}
