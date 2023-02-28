package platform.codingnomads.co.corespring.examples.beanannotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanAnnotationConfig.class);
        ctx.refresh();

        // You don't even need this for this exercise -- all the work is in
        // the bean when the context creates them.
        SampleBean sampleBean = ctx.getBean("friendly_bean_name", SampleBean.class);
        ctx.close();
    }
}
