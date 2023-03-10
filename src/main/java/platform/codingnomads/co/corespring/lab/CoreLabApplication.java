package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreLabApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CoreLabConfig.class);

//        Book novel1 = ctx.getBean("cultureNovel", Book.class);
//        Book novel2 = ctx.getBean("covenantNovel", Book.class);
//
//        Book text1 = ctx.getBean("javaTextBook", Book.class);
//        Book text2 = ctx.getBean("compilerTextbook", Book.class);

        String[] booksOnShelf = ctx.getBeanNamesForType(Book.class);

        System.out.println("On the shelf right now:");

        for (String bookName: booksOnShelf){
            Book book1 = ctx.getBean(bookName, Book.class);
            System.out.println("Title: '" + book1.getTitle() + "', by " + book1.getAuthor() + ", genre: " + book1.getType());
        }


    }

}
