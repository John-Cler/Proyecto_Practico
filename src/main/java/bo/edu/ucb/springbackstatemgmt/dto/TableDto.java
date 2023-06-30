package bo.edu.ucb.springbackstatemgmt.dto;

public class TableDto {
    private Long id;
    private CountryDto country;
    private StateDto state;
    private CityDto city;

    public TableDto() {
    }

    public TableDto(Long id, CountryDto country, StateDto state, CityDto city) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public StateDto getState() {
        return state;
    }

    public void setState(StateDto state) {
        this.state = state;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "TableDto{" +
                "id=" + id +
                ", country=" + country +
                ", state=" + state +
                ", city=" + city +
                '}';
    }
}
