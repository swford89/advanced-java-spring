package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperConfig {
    @Bean
    public Java java() { return new Java("Java", "17"); }

    @Bean
    public Spring spring() { return new Spring("Spring", "3.7"); }

    @Bean
    public SpringDeveloper springDeveloper() { return new SpringDeveloper(java(), spring()); }


}
