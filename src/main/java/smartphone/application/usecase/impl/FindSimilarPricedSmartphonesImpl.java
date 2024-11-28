package smartphone.application.usecase.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import smartphone.application.usecase.port.FindSimilarPricedSmartphones;
import smartphone.domain.entity.Smartphone;
import smartphone.domain.repository.SmartphoneRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

@Slf4j
@RequiredArgsConstructor
public class FindSimilarPricedSmartphonesImpl implements FindSimilarPricedSmartphones {
    private final SmartphoneRepository repository;
    private final ForkJoinPool pool;

    @Override
    public Collection<Smartphone> find(String smartphoneId) {
        try {
            return pool.submit(() -> doFind(smartphoneId)).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error finding similar priced smartphones: ", e);
            throw new RuntimeException(e);
        }
    }

    private List<Smartphone> doFind(String smartphoneId) {
        return repository.findIdsFromSimilarPriced(smartphoneId).parallelStream().map(repository::findById).flatMap(Optional::stream).toList();
    }
}
