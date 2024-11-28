package smartphone.application.usecase.impl;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import smartphone.domain.entity.Smartphone;
import smartphone.domain.repository.SmartphoneRepository;

import java.util.Optional;
import java.util.concurrent.ForkJoinPool;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindSimilarPricedSmartphonesImplTest {
    @Mock
    private SmartphoneRepository repository;

    @Spy
    private ForkJoinPool pool = new ForkJoinPool(10);

    @InjectMocks
    private FindSimilarPricedSmartphonesImpl sut;

    @Test
    void testFind_whenOnlyOneDetailIsFound() {
        var similarPricedIds = Instancio.ofList(String.class).size(10).create();
        var id = Instancio.create(String.class);
        var expectedSmartphone = Instancio.create(Smartphone.class);

        when(repository.findIdsFromSimilarPriced(id)).thenReturn(similarPricedIds);
        when(repository.findById(any())).thenReturn(Optional.of(expectedSmartphone), Optional.empty());

        var result = sut.find(id);

        Assertions.assertThat(result).hasSize(1).allSatisfy(smartphone -> Assertions.assertThat(smartphone).isEqualTo(expectedSmartphone));
    }
}
