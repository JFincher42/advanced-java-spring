package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Artist;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Song;

import java.util.ArrayList;

@Mapper
public interface AlbumMapper {

    @Insert("INSERT INTO mybatis.albums " +
            "(name, year, artist_id) VALUES (#{name}, #{year}, #{artist.id});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewAlbum(Album album);

    @Select("SELECT * FROM albums where id = #{id};")
    @Results(id = "albumResultsMap",
            value = {
                    @Result(property = "name", column = "name"),
                    @Result(property = "year", column = "year"),
                    @Result(property = "artist",
                            column = "artist_id",
                            javaType = Artist.class,
                            one = @One(
                                    select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.ArtistMapper.getArtistByIdWithoutAlbums",
                                    fetchType = FetchType.LAZY
                            )
                    ),
                    @Result(property = "songs",
                            column = "id",
                            javaType = Song.class,
                            many = @Many(
                                    select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.SongMapper.getSongsByAlbumId",
                                    fetchType = FetchType.LAZY
                            )
                    )
            })
    Album getAlbumById(Long id);

    @Select("SELECT * FROM mybatis.albums " +
            "WHERE artist_id = #{artistId};")
    @ResultMap("albumResultsMap")
    ArrayList<Album> getAlbumsByArtistId(Long artistId);

//    @Select("SELECT * from mybatis.albums WHERE id = #{id};")
//    @ResultMap("albumResultsMap")
//    ArrayList<Album> getAlbumsByIdWithSongs(Long id);

    @Select("SELECT * FROM mybatis.albums WHERE id = #{id};")
    ArrayList<Album> getAlbumsByIdWithoutSongs(Long id);
}
