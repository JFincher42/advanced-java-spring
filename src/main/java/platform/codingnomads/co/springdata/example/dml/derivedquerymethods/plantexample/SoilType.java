package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.plantexample;

import lombok.*;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.plantexample.Plant;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "soil_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SoilType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private long ph;

    @Column(nullable = false)
    private boolean dry;

    @OneToMany(mappedBy = "favoriteSoilType")
    private List<Plant> plants;
}
