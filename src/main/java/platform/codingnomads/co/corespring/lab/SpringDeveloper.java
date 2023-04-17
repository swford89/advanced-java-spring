package platform.codingnomads.co.corespring.lab;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class SpringDeveloper {
    private Language language;
    private Framework framework;

    @Autowired
    public SpringDeveloper(Language language, Framework framework) {
        this.language = language;
        this.framework = framework;
    }

}
