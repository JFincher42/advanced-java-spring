package platform.codingnomads.co.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CrudRepoDemo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRepoDemo.class);
    }

    //autowire the UserRepo into the class to gain access to the CRUD methods
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        //create new user
        User user = User.builder().firstName("Bobby").lastName("Bobbert").age(56).build();
        User user2 = User.builder().firstName("Joanne").lastName("Joannadanna").age(36).build();

        //save user and assign what is returned to the user variable.
        user = userRepo.save(user);
        user2 = userRepo.save(user2);



        // Let's do a few more

        List<User> newUsers = new ArrayList<>();
        newUsers.add(User.builder().firstName("Dan").lastName("Akroyd").age(77).build());
        newUsers.add(User.builder().firstName("Chico").lastName("Escuela").age(84).build());

        userRepo.saveAll(newUsers);

//        Iterable<User> users = userRepo.findAll();

        for(User u : userRepo.findAll()){
            System.out.println(u.toString());
        }
        //delete the user using the id of the inserted user object
//        userRepo.deleteById(user.getId());
//        userRepo.deleteById(user2.getId());
    }
}
