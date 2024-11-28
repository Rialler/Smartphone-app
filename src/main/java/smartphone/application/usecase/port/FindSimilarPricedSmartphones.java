package smartphone.application.usecase.port;

import smartphone.domain.entity.Smartphone;

import java.util.Collection;

public interface FindSimilarPricedSmartphones {
    Collection<Smartphone> find(String smartphoneId);
}
