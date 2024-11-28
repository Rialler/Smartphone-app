package smartphone.infrastructure.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smartphone.domain.repository.SmartphoneRepository;
import smartphone.infrastructure.adapter.rest.external.SmartphoneServiceRestCaller;

@Configuration
@EnableConfigurationProperties(value = {SmartphoneCallerServiceProperties.class})
public class SmartphoneCallerServiceConfig {

    @Bean
    public SmartphoneRepository getSmartphoneRepository(SmartphoneCallerServiceProperties properties) {
        var restTemplate = new RestTemplateBuilder().rootUri(properties.getUrl()).build();
        return new SmartphoneServiceRestCaller(restTemplate);
    }
}
