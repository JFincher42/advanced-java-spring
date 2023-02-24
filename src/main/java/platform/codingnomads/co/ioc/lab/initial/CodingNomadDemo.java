package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CodingNomadDemo {
    public static void main(String[] args) {
        // ctx is created by picking a Configuration object
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CodingNomadConfiguration.class);

        // This bean isn't declared in the Configuration object as a @Bean
        // It's getting auto-detected by the @ComponentScan decoration on the Configuration object
        // Because CodingNomad is marked as a @Component, the @ComponentScan can find it and add the bean to the
        // Configuration object, which makes it available here.
        //
        // GUESS: This is using Constructor injection -- Lombok made the constructor, and Spring is using it to create
        // the object when it creates the bean.

        // QUESTION: Could we get rid of the @Component and @ComponentScan, and just add it as a @Bean in the
        // Configuration object
        // It appears to work, but you have to construct the object yourself, rather than letting Spring do it.
        CodingNomad codingNomad = ctx.getBean(CodingNomad.class);

        System.out.println(codingNomad.createAwesomeSoftware());
    }
}
