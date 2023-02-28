package platform.codingnomads.co.corespring.examples.beanscopes.singleton;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("MAIN: Declaring context...");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        System.out.println("MAIN: Registering context...");
        ctx.register(SingletonDemoConfig.class);

        // This call will create all the Singleton beans we need and will use below.
        System.out.println("MAIN: Refreshing context...");
        ctx.refresh();

        // The beans aren't created here
        System.out.println("MAIN: Getting springBean1...");
        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        System.out.println("MAIN: Getting springBean2...");
        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        System.out.println("MAIN: Getting beanTwo1...");
        BeanTwo beanTwo1 = ctx.getBean(BeanTwo.class);
        System.out.println("Bean Two Hash: " + beanTwo1.hashCode());

        System.out.println("MAIN: Getting beanTwo2...");
        BeanTwo beanTwo2 = ctx.getBean(BeanTwo.class);
        System.out.println("Bean Two Hash: " + beanTwo2.hashCode());

        ctx.close();
    }
}
