package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AnotherConfig.class)
public class SimpleConfiguration {
    @Bean(name = "springDevOne")
    public SpringDeveloper springDeveloper() {
        return new SpringDeveloper();
    }
}
