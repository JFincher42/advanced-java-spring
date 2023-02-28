package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Speciality speciality;

    public SpringDeveloper(Address address, Speciality speciality) {
        this.address = address;
        this.speciality = speciality;
    }
}
