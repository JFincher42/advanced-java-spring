package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.lab.initial")
public class CodingNomadConfiguration {



    @Bean
    public Framework framework(){
        return Framework.builder().name("Spring Boot").version("2.5").build();
    }

    @Bean
    public IDE ide(){
        return IDE.builder().name("IntelliJ IDEA").version("2022.2").build();
    }

    @Bean
    public JDK jdk() {
        return JDK.builder().name("OpenJDK").version("11").build();
    }

    @Bean
    public Keyboard kbd(){
        return Keyboard.builder().name("ErgoDox").type("Split").switches("Cherry Brown").build();
    }

    @Bean
    public KeyMapping keyMapping(){
        return KeyMapping.builder().mapping("emacs").build();
    }

//    @Bean
//    public CodingNomad codingNomad(){
//        return new CodingNomad(jdk(), ide(), framework());
//    }
}
