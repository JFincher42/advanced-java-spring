package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class WebServer {
    public WebServer(){
        System.out.println("Server is ready for deployment!");
    }
}
