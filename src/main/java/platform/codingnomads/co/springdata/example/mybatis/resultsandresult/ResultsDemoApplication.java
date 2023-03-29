package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadMusicianData(MusicianMapper musicianMapper){
        return (args) -> {
            Musician musician1 = new Musician();
            musician1.setName("Alex Lifeson");
            musician1.setCurrentBand("Envy of None");

            Musician musician2 = new Musician();
            musician2.setName("Geddy Lee");

            Musician musician3 = new Musician();
            musician3.setName("Arjen Lucassen");
            musician3.setCurrentBand("Supersonic Revolution");

            musicianMapper.insertNewMusician(musician1);
            musicianMapper.insertNewMusician(musician2);
            musicianMapper.insertNewMusician(musician3);

            musicianMapper.getAllMusicians().forEach(System.out::println);

            System.out.println("ENVY OF NONE MUSICIANS");
            musicianMapper.getMusiciansByCurrentBand("Envy of None").forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            //notice the setter names have changed to match Java naming conventions
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtistName("Bon Iver");
            song1.setSongLength(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtistName("Gus Dapperton");
            song2.setSongLength(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

//            Song song3 = songMapper.getSongById(1L);
//            System.out.println(song3.toString());
        };
    }
}
