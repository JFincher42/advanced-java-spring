package platform.codingnomads.co.ioc.examples.dependencylookup;

public class NewGreetingProvider implements GreetingProvider{
    @Override
    public String getGreeting() {
        return "Hello from a new provider! Don't Panic!";
    }
}
