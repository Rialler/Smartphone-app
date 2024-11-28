package smartphone.domain.repository;

import smartphone.domain.entity.Smartphone;

import java.util.Collection;
import java.util.Optional;

public interface SmartphoneRepository {

    Collection<String> findIdsFromSimilarPriced(String smartphoneId);

    Optional<Smartphone> findById(String smartphoneId);
}
