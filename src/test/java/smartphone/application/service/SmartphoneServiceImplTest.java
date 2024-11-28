package smartphone.application.service;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import smartphone.application.usecase.port.FindSimilarPricedSmartphones;
import smartphone.domain.entity.Smartphone;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SmartphoneServiceImplTest {
    @Mock
    private FindSimilarPricedSmartphones findSimilarPricedSmartphonesUseCase;

    @InjectMocks
    private SmartphoneServiceImpl sut;

    @Test
    void findSimilarPriced(){
        var smartphone = Instancio.create(Smartphone.class);
        var id = smartphone.getId();

        when(findSimilarPricedSmartphonesUseCase.find(id)).thenReturn(List.of(smartphone));

        var result = sut.findSimilarPriced(id);


        Assertions.assertThat(result).hasSize(1).isEqualTo(List.of(smartphone));
    }

}
