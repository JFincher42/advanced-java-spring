package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ForeignWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word;

    @ManyToMany(mappedBy = "translation")
    private Set<EnglishWord> englishWord;
}
