package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanLifeCycleConfig implements BeanNameAware {
    @Override
    public void setBeanName(@NotNull String message){
        System.out.println("Change bean name to FUNKY");
    }

}
