package platform.codingnomads.co.ioc.examples.dependencylookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IOCDemoConfiguration {

    @Bean
    public GreetingProvider provider() {
        return new CodingNomadsGreetingProvider();
    }

    @Bean
    public ScottGreetingProvider scottProvider() { return new ScottGreetingProvider(); }

    @Bean
    public GreetingRenderer renderer() {
        GreetingRenderer renderer = new StandardOutGreetingRenderer();
        renderer.setGreetingProvider(provider());
        return renderer;
    }

    @Bean
    public GreetingRenderer scottRenderer() {
        GreetingRenderer greetingRenderer = new StandardOutGreetingRenderer();
        greetingRenderer.setGreetingProvider(scottProvider());
        return greetingRenderer;
    }
}
