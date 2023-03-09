package platform.codingnomads.co.corespring.examples.scopeannotaion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);

        System.out.println("-----Hashcode of SingletonBean-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);

        System.out.println("-----Hashcode of PrototypeBean-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());
        System.out.println();

        SingleSilly sillyBean1 = ctx.getBean(SingleSilly.class);
        SingleSilly sillyBean2 = ctx.getBean(SingleSilly.class);

        System.out.println("-----Hashcode of SingleSillyBeans-----");
        System.out.println(sillyBean1.hashCode());
        System.out.println(sillyBean2.hashCode());

        final ProtoSilly protoSillyBean1 = ctx.getBean(ProtoSilly.class);
        final ProtoSilly protoSillyBean2 = ctx.getBean(ProtoSilly.class);

        System.out.println("-----Hashcode of ProtoSillyBeans-----");
        System.out.println(protoSillyBean1.hashCode());
        System.out.println(protoSillyBean2.hashCode());
        System.out.println();

        ctx.close();
    }
}
