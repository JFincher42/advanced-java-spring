package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@ToString(exclude = "songs")
public class Album {

    private Long id;

    private String name;

    private String year;

    private Artist artist;

    private ArrayList<Song> songs;

    public Album(String name, String year, Artist artist){
        this.name = name;
        this.year = year;
        this.artist = artist;
    }
}
