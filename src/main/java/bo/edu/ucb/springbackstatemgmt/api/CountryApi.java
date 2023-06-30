package bo.edu.ucb.springbackstatemgmt.api;

import bo.edu.ucb.springbackstatemgmt.bl.CountryBl;
import bo.edu.ucb.springbackstatemgmt.dto.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryApi {
    private final CountryBl countryBl;

    @Autowired
    public CountryApi(CountryBl countryBl) {
        this.countryBl = countryBl;
    }

    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryBl.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountryDto getCountryById(@PathVariable("id") String id) {
        return countryBl.getCountryById(id);
    }

    @PostMapping
    public CountryDto createCountry(@RequestBody CountryDto country) {
        return countryBl.createCountry(country);
    }

    @PutMapping("/{id}")
    public CountryDto updateCountryById(@PathVariable("id") String id, @RequestBody CountryDto newCountry) {
        return countryBl.updateCountryById(id, newCountry);
    }
}
