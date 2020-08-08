package pl.sda.travel360.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CITIES_WEATHER")
@Data
public class CityWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String temperature;
    private int cloud;
    private double uvIndex;
    private String condition;
    private double wind;
    private String windDirection;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private WeatherType type;
    @ManyToOne
    private City city;
}
