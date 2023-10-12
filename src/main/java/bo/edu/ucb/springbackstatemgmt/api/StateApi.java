package bo.edu.ucb.springbackstatemgmt.api;

import bo.edu.ucb.springbackstatemgmt.bl.StateBl;
import bo.edu.ucb.springbackstatemgmt.dto.StateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/state")
public class StateApi {
    private final StateBl stateBl;

    @Autowired
    public StateApi(StateBl stateBl) {
        this.stateBl = stateBl;
    }

    @GetMapping
    public List<StateDto> getAllStates() {
        return stateBl.getAllStates();
    }

    @GetMapping("/country/{id}")
    public List<StateDto> getAllStatesByCoountry(@PathVariable("id") Long id) {
        return stateBl.getStatesByCountryId(id);
    }

    @GetMapping("/{id}")
    public StateDto getStateById(@PathVariable("id") String id) {
        return stateBl.getStateById(id);
    }

    @PostMapping
    public StateDto createState(@RequestBody StateDto state) {
        return stateBl.createState(state);
    }

    @PutMapping("/{id}")
    public StateDto updateStateById(@PathVariable("id") String id, @RequestBody StateDto newState) {
        return stateBl.updateStateById(id, newState);
    }
}
