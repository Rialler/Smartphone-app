package smartphone.controller;

import smartphone.input.controller.SimilarPricedController;
import smartphone.input.model.SimilarSmartphone;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class SimilarPricedControllerTest {

    @InjectMocks
    private SimilarPricedController similarPricedController;
    
    private static final String PHONE_ID = "1";

    @Test
     void when_callGetSimilarSmartphonesById_then_returnOKStatus() {

        SimilarSmartphone smartphone = new SimilarSmartphone();

        ResponseEntity<SimilarSmartphone> responseEntity = similarPricedController.findSimilarSmartphones(PHONE_ID);

        Assertions.assertThat(HttpStatus.OK).isEqualTo( responseEntity.getStatusCode());
        Assertions.assertThat(smartphone).isEqualTo(responseEntity.getBody());
    }
}
