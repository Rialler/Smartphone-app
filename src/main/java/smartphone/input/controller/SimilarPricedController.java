package smartphone.input.controller;

import smartphone.input.model.SimilarSmartphone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SimilarPricedController {

    @GetMapping("/smartphone/{id}/similar")
    public ResponseEntity<SimilarSmartphone> findSimilarSmartphones(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
