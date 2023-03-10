package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YAConfigClass {

    @Bean
    public Framework fw2(){
        return new Framework();
    }
}
