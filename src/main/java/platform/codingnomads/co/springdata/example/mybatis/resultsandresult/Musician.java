package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Musician {

    private Long id;

    private String name;

    private String currentBand;

    public Musician(String name, String currentBand){
        this.name = name;
        this.currentBand = currentBand;
    }
}
