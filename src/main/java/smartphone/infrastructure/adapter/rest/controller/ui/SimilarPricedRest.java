package smartphone.infrastructure.adapter.rest.controller.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import smartphone.infrastructure.adapter.rest.controller.model.SimilarSmartphone;

import java.util.List;

@RequestMapping("/smartphone")
public interface SimilarPricedRest {
    @GetMapping("/{id}/similar")
    ResponseEntity<List<SimilarSmartphone>> findSimilarSmartphones(@PathVariable String id);
}
