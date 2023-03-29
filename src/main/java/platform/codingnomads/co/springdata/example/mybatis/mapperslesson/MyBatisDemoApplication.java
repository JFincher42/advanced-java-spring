package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "songs_table.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song newSong = new Song();
            newSong.setName("Tom Sawyer");
            newSong.setAlbum_name("Moving Pictures");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(280);
            songMapper.insertNewSong(newSong);

            newSong.setName("Red Barchetta");
            newSong.setAlbum_name("Moving Pictures");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(280);
            songMapper.insertNewSong(newSong);

            newSong.setName("YYZ");
            newSong.setAlbum_name("Moving Pictures");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(280);
            songMapper.insertNewSong(newSong);

            newSong.setName("Limelight");
            newSong.setAlbum_name("Moving Pictures");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(280);
            songMapper.insertNewSong(newSong);

            newSong.setName("Vital Signs");
            newSong.setAlbum_name("Moving Pictures");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(280);
            songMapper.insertNewSong(newSong);

            newSong.setName("The Camera Eye");
            newSong.setAlbum_name("Moving Pictures");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(280);
            songMapper.insertNewSong(newSong);

            newSong.setName("The Spirit of Radio");
            newSong.setAlbum_name("Permanent Waves");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(280);
            songMapper.insertNewSong(newSong);

            newSong.setName("Jacob's Ladder");
            newSong.setAlbum_name("Permanent Waves");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(280);
            songMapper.insertNewSong(newSong);

            newSong.setName("2112");
            newSong.setAlbum_name("2112");
            newSong.setArtist_name("Rush");
            newSong.setSong_length(580);
            songMapper.insertNewSong(newSong);

//            Song song3 = songMapper.getSongById(1L);
//            System.out.println(song3.toString());

            ArrayList<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);

            longSongs.forEach(System.out::println);

            ArrayList<Song> rushSongs = songMapper.getSongsByArtist("Rush");
            System.out.println("RUSH SONGS");
            System.out.println("==========");
            rushSongs.forEach(System.out::println);

            System.out.println("Deleting Moving Pictures");
            songMapper.deleteSongsByAlbum("Moving Pictures");

            rushSongs = songMapper.getSongsByArtist("Rush");
            System.out.println("CURRENT RUSH SONGS");
            System.out.println("==================");
            rushSongs.forEach(System.out::println);


        };
    }
}
