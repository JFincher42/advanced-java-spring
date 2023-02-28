package platform.codingnomads.co.corespring.examples.beanscopes.prototype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.examples.beanscopes.singleton.BeanTwo;

@SpringBootApplication
public class ProtoTypeDemo {
    public static void main(String[] args) {
        System.out.println("MAIN: Declaring context...");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        System.out.println("MAIN: Registering context...");
        ctx.register(PrototypeDemoConfig.class);

        System.out.println("MAIN: Refreshing context...");
        ctx.refresh();

        // Because these beans are prototypes, the beans are created here.
        System.out.println("MAIN: Getting springBean1...");
        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        System.out.println("MAIN: Getting springBean2...");
        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        System.out.println("MAIN: Getting beanTwo1...");
        BeanTwo beanTwo1 = ctx.getBean(BeanTwo.class);
        System.out.println("Hash code: " + beanTwo1.hashCode());

        System.out.println("MAIN: Getting beanTwo2...");
        BeanTwo beanTwo2 = ctx.getBean(BeanTwo.class);
        System.out.println("Hash code: " + beanTwo2.hashCode());

        ctx.close();
    }
}
