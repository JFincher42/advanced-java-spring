package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;

import java.util.List;

@Service
public class SoilService {

    @Autowired
    SoilTypeRepo soilTypeRepo;

    @Transactional
    public void storeStuff(){
        // Check to see if the repo is empty first
//        if (soilTypeRepo.findAll().isEmpty()){
            // Let's add some soil types

            SoilType sand = SoilType.builder().dry(true).name("sand").ph(7).build();
            SoilType loam = SoilType.builder().dry(false).name("loam").ph(8).build();
            SoilType compost = SoilType.builder().dry(false).name("compost").ph(6).build();

            soilTypeRepo.saveAllAndFlush(List.of(sand, loam, compost));
//        }
    }

    @Transactional
    public void getStuff(){
        System.out.println("ALL SOIL TYPES");
        soilTypeRepo.findAll().forEach(System.out::println);

        System.out.println("\nWET SOILS");
        soilTypeRepo.findWetSoils().forEach(System.out::println);
    }
}
