package smartphone.domain.service;

import smartphone.domain.entity.Smartphone;

import java.util.Collection;

public interface SmartphoneService {
    Collection<Smartphone> findSimilarPriced(String smartphoneId);
}
