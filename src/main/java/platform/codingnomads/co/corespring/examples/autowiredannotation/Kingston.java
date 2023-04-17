package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("kingston")
@ToString
public class Kingston implements RAM{

    private String capacity;

    public Kingston(){
    }
}
