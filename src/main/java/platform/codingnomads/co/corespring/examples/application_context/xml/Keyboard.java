package platform.codingnomads.co.corespring.examples.application_context.xml;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Keyboard {
    private String name;
    private String type;
    private String switches;
}
