package platform.codingnomads.co.ioc.examples.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private Processor processor;
    private OS os;
    private WebCam webcam;

    private HardDrive hd;

    // these fields are being injected from the ApplicationContext
    // if a class contains only one constructor (as this one does), the use of @Autowired is optional
    // if a class contains two or more constructors, @Autowired is required for constructor injection to take place
    public Laptop(Processor processor, OS os, WebCam webcam) {
        this.processor = processor;
        this.os = os;
        this.webcam = webcam;
    }

    @Autowired
    public void setHardDrive(HardDrive hd)
    {
        this.hd = hd;
    }

    public String printLaptopConfiguration() {
        return "processor: " + processor.getCore() + " core " + processor.getName() +
                "\nOS: " + os.getName() + "\nWebCam: " + webcam.getName() + ", Res: (" +
                webcam.getXRes() + ", " + webcam.getYRes() + ")" + "\nHD: " + hd.getName() +
                ", size: " + hd.getCapacity() + "Gb, " + (hd.isSSD() ? "SSD" : "spindle");
    }
}
