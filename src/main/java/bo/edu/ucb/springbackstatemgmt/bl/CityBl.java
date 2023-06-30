package bo.edu.ucb.springbackstatemgmt.bl;

import bo.edu.ucb.springbackstatemgmt.dto.CityDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityBl {
    private final List<CityDto> cities;

    public CityBl() {
        this.cities = new ArrayList<>();
        this.cities.add(new CityDto(1L, "Los Angeles", 1L));
        this.cities.add(new CityDto(2L, "Barcelona", 2L));
        this.cities.add(new CityDto(3L, "Paris", 3L));
    }

    public List<CityDto> getAllCities() {
        return cities;
    }

    public CityDto createCity(CityDto city) {
        if (cities.size() > 0) {
            CityDto lastCity = cities.get(cities.size() - 1);
            city.setId(lastCity.getId() + 1);
        } else {
            city.setId(1L);
        }
        cities.add(city);
        return city;
    }

    public CityDto getCityById(String id) {
        return cities.stream()
                .filter(t -> t.getId().equals(Long.valueOf(id)))
                .findFirst()
                .orElse(null);
    }

    public CityDto updateCityById(String idCity, CityDto newCity) {
        CityDto city = cities.stream()
                .filter(t -> t.getId().equals(Long.valueOf(idCity)))
                .findFirst()
                .orElse(null);
        assert city != null;
        city.setName(newCity.getName());
        city.setStateId(newCity.getStateId());
        return city;
    }
}
