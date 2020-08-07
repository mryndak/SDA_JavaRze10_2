package pl.sda.travel360.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherApiClient {

    private final RestTemplate rest;

    @Value("${application.weather.apiUrl}")
    private String apiUrl;
    @Value("${application.weather.apiCurrentPath}")
    private String apiCurrentPath;
    @Value("${application.weather.apiKey}")
    private String apiKey;

    public GetCurrentWeatherResponse getCurrentWeatherForCity(final String city) {
        String ulr = apiUrl + apiCurrentPath;
        Map<String, Object> variablesMap = buildUriVariablesApiKeyMap();
        variablesMap.put("q", city);

        GetCurrentWeatherResponse result = rest.getForObject(ulr, GetCurrentWeatherResponse.class, variablesMap);
        log.info("Get current weather for city: {}, result: {}", city, result);
        return result;
    }

    private Map<String, Object> buildUriVariablesApiKeyMap() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("key", apiKey);
        return variables;
    }

}
