package platform.codingnomads.co.corespring.examples.componentscanannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import platform.codingnomads.co.corespring.examples.componentscanannotation.cafe.Coffee;
import platform.codingnomads.co.corespring.examples.componentscanannotation.cafe.Food;

@Configuration
@ComponentScan(basePackages = "platform.codingnomads.co.corespring.examples.componentscanannotation.cafe")
public class ComponentScanConfiguration {

    @Bean
    public SampleBean sampleBean() {
        return new SampleBean();
    }

    @Bean
    public Food food() { return new Food(); }

    @Bean
    public Coffee coffee() { return new Coffee(); }


}
