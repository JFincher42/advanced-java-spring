package platform.codingnomads.co.ioc.examples.constructorinjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class WebCam {
    private String name;
    private Integer XRes;
    private Integer YRes;
}
