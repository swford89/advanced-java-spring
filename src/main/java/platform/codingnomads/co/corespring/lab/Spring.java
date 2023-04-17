package platform.codingnomads.co.corespring.lab;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class Spring implements Framework {
    private String name;
    private String version;

    public Spring(String name, String version) {
        this.name = name;
        this.version = version;
    }
}
