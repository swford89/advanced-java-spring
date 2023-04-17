package platform.codingnomads.co.corespring.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreLabApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(DeveloperConfig.class);
        ctx.refresh();

        Java java = ctx.getBean(Java.class);
        Spring spring = ctx.getBean(Spring.class);
        SpringDeveloper springDeveloper = ctx.getBean(SpringDeveloper.class);

        System.out.println("Java bean: " + java);
        System.out.println("Spring bean: " + spring);
        System.out.println("Spring Developer bean: " + springDeveloper);
    }
}
