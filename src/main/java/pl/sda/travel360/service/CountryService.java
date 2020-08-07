package pl.sda.travel360.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.travel360.domain.Country;
import pl.sda.travel360.dto.CountryDto;
import pl.sda.travel360.exceptions.ResourceNotFound;
import pl.sda.travel360.mapper.CountryMapper;
import pl.sda.travel360.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryDto> getAllCountries(Integer minPopulation) {
        return countryRepository.findAllWithMinPopulation(minPopulation)
                .stream()
                .map(countryMapper::map)
                .collect(Collectors.toList());
    }

    public void createCountry(CountryDto country) {
        Country countryToSave = countryMapper.map(country);
        countryRepository.save(countryToSave);
    }

    public CountryDto findByName(String countryName) {
        return countryRepository.findByName(countryName)
                .map(countryMapper::map)
                .orElseThrow(() -> new ResourceNotFound("Country not found"));
    }
}
