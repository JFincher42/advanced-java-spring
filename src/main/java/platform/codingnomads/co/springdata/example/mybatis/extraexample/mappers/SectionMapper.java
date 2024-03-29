package platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Section;

import java.util.List;

@Mapper
public interface SectionMapper {

    @Insert("INSERT INTO mybatis.sections (name) VALUES (#{name});")
    void insertNewSection(String name);

    @Select("SELECT id, name FROM mybatis.sections WHERE id = #{param1};")
    @Results(
            id = "sectionMapperResults",
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(
                            property = "chapters",
                            column = "id",
                            javaType = List.class,
                            many = @Many(
                                    select = "platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ChapterMapper.getChaptersBySectionId",
                                    fetchType = FetchType.LAZY
                            )
                    )
            }
    )
    Section getSectionById(Long sectionId);

    @Select("SELECT id, name FROM mybatis.sections WHERE name = #{sectionName};")
    @ResultMap("sectionMapperResults")
    Section getSectionByName(String sectionName);

//    @Select("SELECT id FROM mybatis.sections WHERE name = #{sectionName};")
//    @ResultMap("sectionMapperResults")
//    Long getSectionIDByName(String sectionName);

    @Delete("DELETE FROM mybatis.sections WHERE id = #{id};")
    int deleteSectionById(Long id);
}
