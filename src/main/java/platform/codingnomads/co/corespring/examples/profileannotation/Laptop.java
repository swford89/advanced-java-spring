package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class Laptop {
    public Laptop(){ System.out.println("Laptop has booted."); }
}
