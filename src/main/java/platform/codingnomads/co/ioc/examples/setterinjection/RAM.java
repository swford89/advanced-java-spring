package platform.codingnomads.co.ioc.examples.setterinjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class RAM {
    private String name;
    private int DDR;
    private String capacity;
}
