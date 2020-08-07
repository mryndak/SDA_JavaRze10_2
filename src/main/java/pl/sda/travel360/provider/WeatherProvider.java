package pl.sda.travel360.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.travel360.client.WeatherApiClient;
import pl.sda.travel360.dto.WeatherDto;

@Service
@RequiredArgsConstructor
public class WeatherProvider {

    private final WeatherApiClient weatherApiClient;

    public WeatherDto getWeatherForCity(String city) {
        String temperature = weatherApiClient.getCurrentWeatherForCity(city)
                .getCurrent()
                .getTemperature();
        return WeatherDto.of(city, temperature);
    }
}
