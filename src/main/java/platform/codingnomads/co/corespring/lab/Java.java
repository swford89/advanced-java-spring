package platform.codingnomads.co.corespring.lab;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class Java implements Language{
    private String name;
    private String version;

    public Java(String name, String version) {
        this.name = name;
        this.version = version;
    }
}
