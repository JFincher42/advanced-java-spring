package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Artist;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Song;

import java.util.ArrayList;

@Mapper
public interface SongMapper {

    @Insert("INSERT INTO mybatis.songs " +
            "(name, album_id, song_length) " +
            "VALUES (#{name}, #{album.id}, #{songLength});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewSong(Song song);

    @Select("SELECT * " +
            "FROM mybatis.songs " +
            "WHERE id = #{param1};")
    @Results(
            id = "songResultMap",
            value = {
                    @Result(property = "name", column = "name"),
                    @Result(property = "songLength", column = "song_length"),
                    @Result(
                            //property to map to
                            property = "album",
                            column = "album_id",
                            javaType = Album.class,
                            one = @One(
                                    select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.AlbumMapper.getAlbumsByIdWithoutSongs",
                                    fetchType = FetchType.LAZY
                            )
                    )
            }
    )
    Song getSongById(Long id);

    @Select("SELECT * " +
            "FROM mybatis.songs " +
            "WHERE name = #{param1};")
    @ResultMap("songResultMap")
    ArrayList<Song> getSongsByName(String name);

//    @Select("SELECT * " +
//            "FROM mybatis.songs " +
//            "WHERE artist_id = #{param1} AND album_name = #{param2};")
//    @ResultMap("songResultMap")
//    ArrayList<Song> getSongsByAlbumAndArtist(Long artistId, String albumName);

    @Select("SELECT *" +
            "FROM mybatis.songs " +
            "WHERE album_id = #{param1};")
    @ResultMap("songResultMap")
    ArrayList<Song> getSongsByAlbumId(Long albumId);

    @Update("UPDATE mybatis.songs " +
            "SET name = #{name}, album_id = #{album.id}, song_length = #{songLength} " +
            "WHERE id = #{id};")
    void updateSong(Song song);

    @Delete("DELETE FROM mybatis.songs WHERE id = #{param1};")
    void deleteSongById(Long songId);

//    @Delete("DELETE FROM mybatis.songs " +
//            "WHERE artist_id = #{artistId} AND album_name = #{albumName};")
//    void deleteSongsByAlbumAndArtist(Long artistId, String albumName);

}
