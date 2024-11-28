package smartphone.infrastructure.adapter.rest.controller.controller;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import smartphone.domain.entity.Smartphone;
import smartphone.domain.service.SmartphoneService;
import smartphone.infrastructure.adapter.rest.controller.SimilarPricedController;
import smartphone.infrastructure.adapter.rest.controller.model.SimilarSmartphone;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SimilarPricedControllerTest {

    @Mock
    private SmartphoneService service;

    @InjectMocks
    private SimilarPricedController similarPricedController;

    @Test
    void when_callGetSimilarSmartphonesById_then_returnOKStatus() {

        var expectedSmartphone = Instancio.create(Smartphone.class);
        when(service.findSimilarPriced(expectedSmartphone.getId())).thenReturn(List.of(expectedSmartphone));


        ResponseEntity<List<SimilarSmartphone>> responseEntity = similarPricedController.findSimilarSmartphones(expectedSmartphone.getId());

        Assertions.assertThat(HttpStatus.OK).isEqualTo(responseEntity.getStatusCode());
        Assertions.assertThat(responseEntity.getBody()).hasSize(1).allSatisfy(smartphone -> Assertions.assertThat(smartphone).usingRecursiveComparison().isEqualTo(expectedSmartphone));
    }
}
