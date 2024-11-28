package smartphone.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smartphone.application.usecase.port.FindSimilarPricedSmartphones;
import smartphone.domain.entity.Smartphone;
import smartphone.domain.service.SmartphoneService;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SmartphoneServiceImpl implements SmartphoneService {
    private final FindSimilarPricedSmartphones findSimilarPricedSmartphonesUseCase;

    @Override
    public Collection<Smartphone> findSimilarPriced(String smartphoneId) {
        return findSimilarPricedSmartphonesUseCase.find(smartphoneId);
    }
}
