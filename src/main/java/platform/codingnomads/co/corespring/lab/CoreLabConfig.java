package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("xml-config/books.xml")
public class CoreLabConfig {

    @Bean("covenantNovel")
    public Book covenantNovel(){
        return new Book("Lord Foul's Bane", "Stephen R. Donalson", "Fiction");
    }

    @Bean("javaTextBook")
    public Book javaTextBook(){
        return new Book("Building Java Programs", "Stuart Reges and Marty Stepp", "textbook");
    }
}
