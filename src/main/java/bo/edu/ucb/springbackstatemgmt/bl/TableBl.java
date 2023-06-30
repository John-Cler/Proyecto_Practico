package bo.edu.ucb.springbackstatemgmt.bl;

import bo.edu.ucb.springbackstatemgmt.dto.TableDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableBl {
    private final List<TableDto> tables;

    public TableBl() {
        this.tables = new ArrayList<>();
    }

    public List<TableDto> getAllTables() {
        return tables;
    }

    public List<TableDto> createTables(List<TableDto> inputTables) {
        List<TableDto> createdTables = new ArrayList<>();

        for (TableDto table : inputTables) {
            if (isDuplicate(table)) {
                throw new IllegalArgumentException("Error: A row already exists in the table.");
            }

            Long newId = generateNewId();
            TableDto newTable = new TableDto();
            newTable.setId(newId);
            newTable.setCountry(table.getCountry());
            newTable.setState(table.getState());
            newTable.setCity(table.getCity());

            createdTables.add(newTable);
            tables.add(newTable);
        }

        return createdTables;
    }

    private boolean isDuplicate(TableDto newTable) {
        for (TableDto existingTable : tables) {
            if (existingTable.getCountry().getId().equals(newTable.getCountry().getId())
                    && existingTable.getState().getId().equals(newTable.getState().getId())
                    && existingTable.getCity().getId().equals(newTable.getCity().getId())) {
                return true; // Se encontró una fila duplicada
            }
        }
        return false; // No se encontraron filas duplicadas
    }

    private Long generateNewId() {
        if (tables.size() > 0) {
            TableDto lastTable = tables.get(tables.size() - 1);
            return lastTable.getId() + 1;
        } else {
            return 1L;
        }
    }
}
