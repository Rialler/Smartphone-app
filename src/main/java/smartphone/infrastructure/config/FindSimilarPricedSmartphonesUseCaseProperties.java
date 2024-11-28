package smartphone.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "usecase.find-similar-priced")
public class FindSimilarPricedSmartphonesUseCaseProperties {
    private Integer parallelThreadPool = 10;
}
