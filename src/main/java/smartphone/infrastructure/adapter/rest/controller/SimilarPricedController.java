package smartphone.infrastructure.adapter.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import smartphone.domain.service.SmartphoneService;
import smartphone.infrastructure.adapter.rest.controller.mapper.SimilarSmartphoneMapper;
import smartphone.infrastructure.adapter.rest.controller.model.SimilarSmartphone;
import smartphone.infrastructure.adapter.rest.controller.ui.SimilarPricedRest;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SimilarPricedController implements SimilarPricedRest {
    private final SmartphoneService service;

    public ResponseEntity<List<SimilarSmartphone>> findSimilarSmartphones(@PathVariable String id) {
        ResponseEntity<List<SimilarSmartphone>> response;
        try {
            var similarSmartphones = service.findSimilarPriced(id).parallelStream().map(SimilarSmartphoneMapper.INSTANCE::fromDomain).toList();
            response = ResponseEntity.status(HttpStatus.OK).body(similarSmartphones);
        } catch (Exception e) {
            response = ResponseEntity.internalServerError().build();
        }

        return response;
    }

}
