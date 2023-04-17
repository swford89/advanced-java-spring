package platform.codingnomads.co.ioc.examples.dependencylookup;

public class ScottGreetingProvider implements GreetingProvider{

    @Override
    public String getGreeting(){
        return "Scott says hellooooo!";
    }
}
