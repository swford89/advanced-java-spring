package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Person person;

    public SpringDeveloper(Address address, Person person) {
        this.address = address;
        this.person = person;
    }
}
