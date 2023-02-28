package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanTwo implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("No, my name's not 'baby', it's " + name + "!");
    }
}
