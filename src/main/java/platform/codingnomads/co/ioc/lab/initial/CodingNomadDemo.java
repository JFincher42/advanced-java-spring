package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CodingNomadDemo {

    public static void main(String[] args) {
        // ctx is created by picking a Configuration object
        // This automagically creates the Beans defined in the configuration class
        // QUESTION: What if I want more than one of a particular class of Bean?
        //           For example, I want two Framework beans available -- how do I do that?
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
        // ME: It appears to work, but you have to construct the object yourself, rather than letting Spring do it.
        // A:

        // QUESTION: Could we just declare this as private final here, like we did in the CodingNomad class, and
        // avoid doing a .getBean() call?
        // ME: I don't think so, because it has to be static to be accessed here, and we can't auto wire it.
        //     We also can't inject it, since main() can only access static members -- beans are dynamic in nature,
        //     and this is needed to get a dynamic

        CodingNomad codingNomad = ctx.getBean(CodingNomad.class);

        System.out.println(codingNomad.createAwesomeSoftware());
    }
}
