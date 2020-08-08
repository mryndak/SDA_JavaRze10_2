package pl.sda.travel360.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITIES")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "city",
            cascade = CascadeType.ALL
    )
    private List<CityWeather> weathers;
}
