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
public class EnglishWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word;

    @Column(nullable = false)
    private String partOfSpeech;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "english_translations")
    private Set<ForeignWord> translation;

}
