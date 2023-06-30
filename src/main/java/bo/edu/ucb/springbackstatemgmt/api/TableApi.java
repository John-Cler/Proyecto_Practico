package bo.edu.ucb.springbackstatemgmt.api;

import bo.edu.ucb.springbackstatemgmt.bl.TableBl;
import bo.edu.ucb.springbackstatemgmt.dto.TableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/table")
public class TableApi {
    private final TableBl tableBl;

    @Autowired
    public TableApi(TableBl tableBl) {
        this.tableBl = tableBl;
    }

    @GetMapping
    public List<TableDto> getAllTables() {
        return tableBl.getAllTables();
    }

    @PostMapping
    public ResponseEntity<List<TableDto>> createTables(@RequestBody List<TableDto> tables) {
        try {
            List<TableDto> createdTables = tableBl.createTables(tables);
            return ResponseEntity.ok(createdTables);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
