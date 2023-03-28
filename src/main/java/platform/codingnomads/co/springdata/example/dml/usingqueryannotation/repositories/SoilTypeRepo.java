package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.ArrayList;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    // JPQL
    @Query("SELECT st from SoilType st")
    ArrayList<SoilType> findAll();

    @Query("SELECT st from SoilType st WHERE dry = true")
    ArrayList<SoilType> findDrySoils();

    @Query("SELECT st from SoilType st WHERE dry = false")
    ArrayList<SoilType> findWetSoils();


}
