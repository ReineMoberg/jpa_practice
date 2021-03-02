package se.lexicon.ReineMoberg.jpa_practice.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.ReineMoberg.jpa_practice.entity.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDaoImplTest {

    @Autowired
    StudentDao testStudentDao;
    Student testStudent;

    @BeforeEach
    public void setup(){
        testStudent = new Student(      //No ID here, gets created in database
                "Reine",
                "Moberg",
                "mail.mail@gmail.com",
                LocalDate.parse("1969-11-26"),
                false,
                LocalDateTime.now());
    }

    @Test
    @DisplayName("Create student")  //Check in database if created
    public void testCreateStudent(){
        testStudentDao.create(testStudent);
    }

    @Test
    @DisplayName("Find student by ID")
    public void testFindById() {
        Student expectedStudent = testStudentDao.create(testStudent);
        Student actualStudent = testStudentDao.findById(1);
        Assertions.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    @DisplayName("Save list of students")
    public void testSaveStudents(){
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("Test1", "Test1", "test1@test.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now());
        Student student2 = new Student("Test2", "Test2", "test2@test.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now());
        Student student3 = new Student("Test3", "Test3", "test3@test.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now());
        Student student4 = new Student(null, null, "test1@test.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now()); //Invalid student
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        //studentList.add(student4); //If invalid student is added, none will be added in database
        testStudentDao.saveStudents(studentList);
    }
}
