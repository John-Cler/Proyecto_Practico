package bo.edu.ucb.springbackstatemgmt.bl;

import bo.edu.ucb.springbackstatemgmt.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryBl {
    private final List<CountryDto> countries;

    public CountryBl() {
        this.countries = new ArrayList<>();
        this.countries.add(new CountryDto(1L, "España"));
        this.countries.add(new CountryDto(2L, "Estados Unidos"));
        this.countries.add(new CountryDto(3L, "Francia"));
    }

    public List<CountryDto> getAllCountries() {
        return countries;
    }

    public CountryDto createCountry(CountryDto country) {
        // Obtenemos el último elemento de la lista  y le sumamos 1 para obtener el id
        // del nuevo elemento
        if (countries.size() > 0) {
            CountryDto lastCountry = countries.get(countries.size() - 1);
            country.setId(lastCountry.getId() + 1);
        } else {
            country.setId(1L);
        }
        countries.add(country);
        return country;
    }

    public CountryDto getCountryById(String id) {
        // Buscamos el país en la lista
        return countries.stream()
                .filter(t -> t.getId().equals(Long.valueOf(id)))
                .findFirst()
                .orElse(null);
    }

    public CountryDto updateCountryById(String idCountry, CountryDto newCountry) {
        // Buscamos el país en la lista
        CountryDto country = countries.stream()
                .filter(t -> t.getId().equals(Long.valueOf(idCountry)))
                .findFirst()
                .orElse(null);
        assert country != null;
        country.setName(newCountry.getName());
        return country;
    }
}

