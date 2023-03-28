package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="chiefs")
@NoArgsConstructor
@Getter
@Setter
public class Chief {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, name="first_name")
    private String firstName;

    @Column(nullable = false, name="last_name")
    private String lastName;

    @OneToOne
    private Car car;
}
