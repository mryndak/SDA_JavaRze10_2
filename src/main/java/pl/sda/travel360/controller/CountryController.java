package pl.sda.travel360.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.travel360.dto.CountryDto;
import pl.sda.travel360.service.CountryService;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;

@RequiredArgsConstructor
@RequestMapping(path = "/countries", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class CountryController {

    private final CountryService service;

    @ApiOperation(value = "Returns all countries with optional minimum population filter", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Get all countries succeeded")
    @GetMapping
    public ResponseEntity<List<CountryDto>> getCountries(@RequestParam("minPopulation") Integer minPopulation) {
        List<CountryDto> countries = service.getAllCountries(minPopulation);
        return ResponseEntity.ok()
                .body(countries);
    }

    @ApiOperation(value = "Returns a specific country with given name", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Get a specific country succeeded")
    @GetMapping("/{countryName}")
    public CountryDto getCountryByName(@PathVariable String countryName) {
        return service.findByName(countryName);
    }

    @PostMapping
    public ResponseEntity<Void> createCountry(@RequestBody CountryDto newCountry) {
        service.createCountry(newCountry);
        return noContent().build();
    }

}