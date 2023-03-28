package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifecycleCallbackDemo {

    @Autowired
    PrintEntityRepository printEntityRepository;
    public static void main(String[] args) {
        SpringApplication.run(LifecycleCallbackDemo.class);
    }

    @Bean
    public CommandLineRunner runStuff(PrintEntityRepository printEntityRepository) {
        return (args) -> {
            // put your logic here
            PrintEntity printEntity = new PrintEntity();

            printEntity = printEntityRepository.save(printEntity);

            printEntity.setId(printEntity.getId() + 2);

            printEntity = printEntityRepository.save(printEntity);

        };
    }
}
