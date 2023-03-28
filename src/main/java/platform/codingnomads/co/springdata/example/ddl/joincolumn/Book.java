package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title")
    private String title;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_genre")
    private Genre genre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "owned_by", unique = true)
    private Set<User> owners;

}
