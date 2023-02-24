package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {

    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    // Setting injection
    private Keyboard kbd;

    @Autowired
    public void setKbd(Keyboard kbd){
        this.kbd = kbd;
    }

    // Field injection
    @Autowired
    private KeyMapping keyMapping;

    public String createAwesomeSoftware(){
        return MessageFormat.format("This coding nomad is creating awesome software using, " +
                "IDE: {0}:{1}, JDK: {2}:{3}, and Framework {4}:{5},\n" +
                "using a {6} {7} keyboard with {8} switches and a {9} keymap.",
                ide.getName(), ide.getVersion(),
                jdk.getName(), jdk.getVersion(),
                framework.getName(), framework.getVersion(),
                kbd.getName(), kbd.getType(), kbd.getSwitches(),
                keyMapping.getMapping());
    }
}
