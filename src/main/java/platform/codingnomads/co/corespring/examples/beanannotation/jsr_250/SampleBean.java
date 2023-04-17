package platform.codingnomads.co.corespring.examples.beanannotation.jsr_250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SampleBean {

    public SampleBean() {
        System.out.println("bean is getting ready!");
    }

    @PostConstruct
    public void init() {
        System.out.println("bean @PostConstruct is gathering resources..");
    }

    @PostConstruct
    public void doStuff() { System.out.println("bean @PostConstruct --- doStuff() called"); }

    @PreDestroy
    public void preCleanup() { System.out.println("bean @PreDestroy --- preCleanup() called"); }

    @PreDestroy
    public void cleanup() {
        System.out.println("time to @PreDestroy and head home..");
    }



}
