package se.lexicon.ReineMoberg.jpa_practice.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentTest {

    Student testStudent;
    LocalDateTime currentDateTime;

    @BeforeEach
    public void setup() {
        currentDateTime = LocalDateTime.now();
        testStudent = new Student(
                1,
                "Reine",
                "Moberg",
                "mail.mail@gmail.com",
                LocalDate.parse("1969-11-26"),
                false,
                currentDateTime);
    }

    @Test
    @DisplayName("Create student object")
    public void testCreateStudent() {
        Assertions.assertEquals(1, testStudent.getStudentId());
        Assertions.assertEquals("Reine", testStudent.getFirstName());
        Assertions.assertEquals("Moberg", testStudent.getLastName());
        Assertions.assertEquals("mail.mail@gmail.com", testStudent.getEmail());
    }

    @Test
    @DisplayName("Equals method")
    public void testEqualsMethod() {
        Student expectedStudent = new Student(
                1,
                "Reine",
                "Moberg",
                "mail.mail@gmail.com",
                LocalDate.parse("1969-11-26"),
                false,
                currentDateTime);
        Assertions.assertEquals(expectedStudent, testStudent);
    }

    @Test
    @DisplayName("Hash code method")
    public void testHashCode(){
        Student expectedStudent = new Student(
                1,
                "Reine",
                "Moberg",
                "mail.mail@gmail.com",
                LocalDate.parse("1969-11-26"),
                false,
                currentDateTime);
        Assertions.assertEquals(expectedStudent.hashCode(), testStudent.hashCode());
    }
}
