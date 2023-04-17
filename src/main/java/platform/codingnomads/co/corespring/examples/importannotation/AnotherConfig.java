package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfig {
    @Bean(name = "springDevTwo")
    public SpringDeveloper springDeveloper() { return new SpringDeveloper(); }
}
