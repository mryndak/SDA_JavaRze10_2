package pl.sda.travel360.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
@Builder
public class CountryDto {
    private String name;
    private String capital;
    private String language;
    private String currency;
    private int population;
}