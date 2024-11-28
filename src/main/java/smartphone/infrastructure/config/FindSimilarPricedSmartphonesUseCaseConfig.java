package smartphone.infrastructure.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smartphone.application.usecase.impl.FindSimilarPricedSmartphonesImpl;
import smartphone.application.usecase.port.FindSimilarPricedSmartphones;
import smartphone.domain.repository.SmartphoneRepository;

import java.util.concurrent.ForkJoinPool;

@Configuration
@EnableConfigurationProperties(value = {FindSimilarPricedSmartphonesUseCaseProperties.class})
public class FindSimilarPricedSmartphonesUseCaseConfig {

    @Bean
    public FindSimilarPricedSmartphones getFindSimilarPricedSmartphones(FindSimilarPricedSmartphonesUseCaseProperties properties, SmartphoneRepository repository){
        return new FindSimilarPricedSmartphonesImpl(repository, new ForkJoinPool(properties.getParallelThreadPool()));
    }
}
