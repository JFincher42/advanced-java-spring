package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.plantexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class PlantApplication implements CommandLineRunner {

    @Autowired
    PlantRepo plantRepo;

//    @Autowired
//    SoilRepo soilRepo;

    public static void main(String[] args) {
        SpringApplication.run(PlantApplication.class);
    }

    @Override
//    @Transactional
    public void run(String... args) throws Exception {
        SoilType compost = SoilType.builder().name("compost").dry(false).ph(10).build();
        SoilType swamp = SoilType.builder().name("swamp").dry(false).ph(20).build();
        SoilType arid = SoilType.builder().name("arid").dry(true).ph(1).build();
//        SoilType compost2 = SoilType.builder().name("compost").dry(false).ph(10).build();

//        soilRepo.save(compost);
//        soilRepo.save(swamp);
//        soilRepo.save(arid);

        Plant tomato = Plant.builder()
                .name("tomato")
                .fruitBearing(true)
                .favoriteSoilType(compost)
                .sunType("full sun")
                .numDaysTillRipeFruit(60)
                .build();

        Plant cranberry = Plant.builder()
                .name("cranberry")
                .fruitBearing(true)
                .favoriteSoilType(swamp)
                .sunType("partial sun")
                .numDaysTillRipeFruit(100)
                .build();

        Plant cactus = Plant.builder()
                .name("cactus")
                .fruitBearing(true)
                .favoriteSoilType(arid)
                .sunType("full sun")
                .numDaysTillRipeFruit(180)
                .build();

        Plant basil = Plant.builder()
                .name("basil")
                .fruitBearing(false)
                .favoriteSoilType(compost)
                .sunType("full sun")
                .numDaysTillRipeFruit(null)
                .build();

        plantRepo.save(tomato);
        plantRepo.save(cranberry);
        plantRepo.save(cactus);
        // THis fails because the compost entity is detached when
        // tomato is saved.
        // Resolve it by making this entire method transactional, or
        // Using an EntityManager to get the compost entity from the DB
        plantRepo.save(basil);

        // DEMONSTRATE USE OF DERIVED QUERY METHODS

        System.out.println("\n********* findByName() *********");
        List<Plant> plants1 = plantRepo.findByName("cactus");
        plants1.forEach(System.out::println);

        System.out.println("\n********* findByFruitBearingAndFavoriteSoilType_dry *********");
        List<Plant> plants2 = plantRepo.findByFruitBearingAndFavoriteSoilType_dry(true, true);
        plants2.forEach(System.out::println);

        System.out.println("\n********* findByNameEndingWith() *********");
        List<Plant> plants3 = plantRepo.findByNameEndingWith("berry");
        plants3.forEach(System.out::println);

        System.out.println("\n********* findFirstByFavoriteSoilType_dryIsTrue() *********");
        Plant plant4 = plantRepo.findFirstByFavoriteSoilType_dryIsTrue();
        System.out.println(plant4.toString());

        System.out.println("\n********* findByNumDaysTillRipeFruitGreaterThan(100) *********");
        List<Plant> plants5 = plantRepo.findByNumDaysTillRipeFruitGreaterThan(10);
        plants5.forEach(System.out::println);

        plantRepo.deleteAll();
    }
}
