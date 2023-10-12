package bo.edu.ucb.springbackstatemgmt.bl;

import bo.edu.ucb.springbackstatemgmt.dto.StateDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateBl {
    private final List<StateDto> states;

    public StateBl() {
        this.states = new ArrayList<>();
        this.states.add(new StateDto(1L, "California", 2L));
        this.states.add(new StateDto(2L, "Madrid", 1L));
        this.states.add(new StateDto(3L, "Paris", 3L));
    }

    public List<StateDto> getAllStates() {
        return states;
    }

    // Obtenemos todos los estados por el id del país
    public List<StateDto> getStatesByCountryId(Long countryId) {
        return states.stream()
                .filter(state -> state.getCountryId().equals(countryId))
                .collect(Collectors.toList());
    }

    public StateDto createState(StateDto state) {
        if (states.size() > 0) {
            StateDto lastState = states.get(states.size() - 1);
            state.setId(lastState.getId() + 1);
        } else {
            state.setId(1L);
        }
        states.add(state);
        return state;
    }

    public StateDto getStateById(String id) {
        return states.stream()
                .filter(t -> t.getId().equals(Long.valueOf(id)))
                .findFirst()
                .orElse(null);
    }

    public StateDto updateStateById(String idState, StateDto newState) {
        StateDto state = states.stream()
                .filter(t -> t.getId().equals(Long.valueOf(idState)))
                .findFirst()
                .orElse(null);
        assert state != null;
        state.setName(newState.getName());
        state.setCountryId(newState.getCountryId());
        return state;
    }
}

