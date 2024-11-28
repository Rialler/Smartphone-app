package smartphone.infrastructure.adapter.rest.external;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import smartphone.domain.entity.Smartphone;
import smartphone.domain.repository.SmartphoneRepository;
import smartphone.infrastructure.adapter.rest.external.mapper.SmartphoneMapper;
import smartphone.infrastructure.adapter.rest.external.model.SmartphoneModel;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class SmartphoneServiceRestCaller implements SmartphoneRepository {
    private final RestTemplate restTemplate;

    @Override
    public Collection<String> findIdsFromSimilarPriced(String smartphoneId) {
        var response = restTemplate.getForEntity("/smartphone/{smartphoneId}/similarpricedids", String[].class, smartphoneId);

        if (response.getStatusCode().isError()) {
            String message = "Error calling to findIdsOfSimilarByPrice.";
            log.error("{} Status code: {}", message, response.getStatusCode());
            throw new RuntimeException(message);
        }

        return Optional.ofNullable(response.getBody()).map(Arrays::asList).orElse(List.of());
    }

    @Override
    public Optional<Smartphone> findById(String smartphoneId) {
        Optional<Smartphone> smartphoneOptional;
        try {
            var response = restTemplate.getForEntity("/smartphone/{smartphoneId}", SmartphoneModel.class, smartphoneId);
            smartphoneOptional = Optional.ofNullable(response.getBody()).map(SmartphoneMapper.INSTANCE::toDomain);
        } catch (HttpClientErrorException e) {
            smartphoneOptional = Optional.empty();
        }

        return smartphoneOptional;
    }
}
