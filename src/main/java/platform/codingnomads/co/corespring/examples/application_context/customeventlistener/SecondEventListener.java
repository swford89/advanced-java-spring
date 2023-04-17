package platform.codingnomads.co.corespring.examples.application_context.customeventlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SecondEventListener implements ApplicationListener<UserRegistrationCompletedEvent> {
    @Override
    public void onApplicationEvent(UserRegistrationCompletedEvent event) {
        System.out.println("-----SecondEventListener also listening-----");
        System.out.println("-----Event Message: " + event.getMessage() + "-----");
    }
}
