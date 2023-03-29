package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface MusicianMapper {

    @Insert("INSERT INTO mybatis.musicians " +
            "(name, current_band) " +
            "VALUES (#{name}, #{currentBand});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewMusician(Musician musician);

    @Select("SELECT * from mybatis.musicians " +
            "WHERE id = #{param1};")
    @Results(
            id = "musiciansResultMap",
            value = {
                    @Result(property = "name", column = "name"),
                    @Result(property = "currentBand", column = "current_band")
            }
    )
    Musician getMusicianById(Long Id);

    @Select("SELECT * from mybatis.musicians")
    @ResultMap("musiciansResultMap")
    ArrayList<Musician> getAllMusicians();

    @Select("SELECT * from mybatis.musicians "+
            "WHERE current_band = #{currentBand};")
    @ResultMap("musiciansResultMap")
    ArrayList<Musician> getMusiciansByCurrentBand(String currentBand);

    @Delete("DELETE from mybatis.musicians WHERE id = #{param1};")
    void deleteMusicianbyId(long id);
}
