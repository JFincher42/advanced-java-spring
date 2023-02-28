package platform.codingnomads.co.corespring.examples.beanscopes.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import platform.codingnomads.co.corespring.examples.beanscopes.singleton.BeanTwo;

@Configuration
public class PrototypeDemoConfig {
    @Bean
    @Scope(value = "prototype")
    public SpringBean springBean() {
        return new SpringBean();
    }

    @Bean
    @Scope(value = "prototype")
    public BeanTwo beanTwo(){
        return new BeanTwo();
    }
}
