package bo.edu.ucb.springbackstatemgmt.api;

import bo.edu.ucb.springbackstatemgmt.bl.CityBl;
import bo.edu.ucb.springbackstatemgmt.dto.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityApi {
    private final CityBl cityBl;

    @Autowired
    public CityApi(CityBl cityBl) {
        this.cityBl = cityBl;
    }

    @GetMapping
    public List<CityDto> getAllCities() {
        return cityBl.getAllCities();
    }

    @GetMapping("/{id}")
    public CityDto getCityById(@PathVariable("id") String id) {
        return cityBl.getCityById(id);
    }

    @PostMapping
    public CityDto createCity(@RequestBody CityDto city) {
        return cityBl.createCity(city);
    }

    @PutMapping("/{id}")
    public CityDto updateCityById(@PathVariable("id") String id, @RequestBody CityDto newCity) {
        return cityBl.updateCityById(id, newCity);
    }
}
