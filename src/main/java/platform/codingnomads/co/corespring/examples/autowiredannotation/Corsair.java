package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("corsair")
@ToString
public class Corsair implements RAM {

    private String capacity;

    public Corsair(){
    }
}
