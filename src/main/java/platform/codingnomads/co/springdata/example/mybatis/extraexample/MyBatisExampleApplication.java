package platform.codingnomads.co.springdata.example.mybatis.extraexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ChapterMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ImageMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.LessonMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.SectionMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Chapter;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Section;

@SpringBootApplication
public class MyBatisExampleApplication implements CommandLineRunner {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "database_structure.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    LessonMapper lessonMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    SectionMapper sectionMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisExampleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        // Start with some sections
        sectionMapper.insertNewSection("First Section");
        sectionMapper.insertNewSection("Section the Second");

        // Let's add a few chapters
        chapterMapper.insertNewChapter("Chapter 1: The Beginning",
                sectionMapper.getSectionByName("First Section").getId());
        chapterMapper.insertNewChapter("Chapter 2: What Comes Next",
                sectionMapper.getSectionByName("First Section").getId());

        chapterMapper.insertNewChapter("Chapter 3: Oh Crap It's Over",
                sectionMapper.getSectionByName("Section the Second").getId());

        // Now a Lesson for each chapter
        lessonMapper.insertNewLesson("Learn you something",
                "Study hard",
                chapterMapper.getChapterByName("Chapter 1: The Beginning").getId());
        lessonMapper.insertNewLesson("Why work hard", "Earn money", chapterMapper.getChapterByName("Chapter 1: The Beginning").getId());
        lessonMapper.insertNewLesson("Just do it", "Nike sucks", chapterMapper.getChapterByName("Chapter 2: What Comes Next").getId());
        lessonMapper.insertNewLesson("Go forth and prosper", "Vulcan wisdom", chapterMapper.getChapterByName("Chapter 3: Oh Crap It's Over").getId());
        lessonMapper.insertNewLesson("Hey, badda boom", "Whattaya gonna do", chapterMapper.getChapterByName("Chapter 3: Oh Crap It's Over").getId());

        // How about an image or two
        imageMapper.insertNewImage("Picture this", new byte[] {0,1,2,3,4,5});
        imageMapper.insertNewImage("Imagine that", new byte[] {10,11,12,13,14,15});

        // Link those to lessons
        lessonMapper.addImageToLesson(lessonMapper.getLessonByName("Learn you something").getId(), "Picture this");
        lessonMapper.addImageToLesson(lessonMapper.getLessonByName("Just do it").getId(), "Imagine that");

        // Now let's print some shite
        System.out.println(sectionMapper.getSectionByName("First Section"));
        System.out.println(sectionMapper.getSectionByName("Section the Second"));

    }
}
