package smartphone.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "external.smartphone-service")
public class SmartphoneCallerServiceProperties {
    private String url;
}
