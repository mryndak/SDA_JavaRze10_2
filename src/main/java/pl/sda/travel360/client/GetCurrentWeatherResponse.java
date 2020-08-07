package pl.sda.travel360.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetCurrentWeatherResponse {

    private CurrentWeather current;

    @Data
    public static class CurrentWeather {

        @JsonProperty("temp_c")
        private String temperature;
    }
}
