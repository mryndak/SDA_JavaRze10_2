package pl.sda.travel360.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.travel360.dto.WeatherDto;
import pl.sda.travel360.provider.WeatherProvider;

@RequiredArgsConstructor
@RequestMapping(path = "/weather", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class WeatherController {

    private final WeatherProvider weatherProvider;

    @GetMapping
    public WeatherDto getWeatherForCity(@RequestParam("city") String city) {
        return weatherProvider.getWeatherForCity(city);
    }
}
