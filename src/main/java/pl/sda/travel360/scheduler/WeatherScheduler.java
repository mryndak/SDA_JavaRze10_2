package pl.sda.travel360.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.sda.travel360.client.WeatherApiClient;
import pl.sda.travel360.domain.City;
import pl.sda.travel360.repository.CityRepository;
import pl.sda.travel360.repository.CityWeatherRepository;


@Service
@RequiredArgsConstructor
public class WeatherScheduler {

    private final WeatherApiClient weatherApiClient;
    private final CityRepository cityRepository;
    private final CityWeatherRepository cityWeatherRepository;

    @Scheduled(cron = "0 */1 * * * *")
    public void updateWeather() {
        var cities = cityRepository.findAll();
    }

    private void fetchAndUpdateWeather(City city) {
        try {
            final String cityName = city.getName();
            var response = weatherApiClient.getCurrentWeatherForCity(cityName);
        } catch (Exception e) {

        }
    }
}
