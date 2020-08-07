package pl.sda.travel360.mapper;

import org.mapstruct.Mapper;
import pl.sda.travel360.domain.Country;
import pl.sda.travel360.dto.CountryDto;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto map(Country country);
    Country map(CountryDto country);
}