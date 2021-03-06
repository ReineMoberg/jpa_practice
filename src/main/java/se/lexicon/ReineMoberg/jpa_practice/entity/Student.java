package se.lexicon.ReineMoberg.jpa_practice.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity //Define class as database entity (Table)
//@Table(name = "TBL_STUDENT") //If we want another name than 'student' in table
public class Student {

    @Id  //Primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Means auto_increment
    private int studentId;
    @Column(nullable = false, length = 255)
    private String firstName;
    @Column(nullable = false, length = 255)
    private String lastName;
    @Column(nullable = false, length = 100, unique = true)  //Unique value required
    private String email;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false, columnDefinition = "tinyint(1) default 1") //Boolean with default value 1
    private boolean status;
    @Column(nullable = false)
    private LocalDateTime registerDate;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, LocalDate birthDate, boolean status, LocalDateTime registerDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.status = status;
        this.registerDate = registerDate;
    }

    public Student(int studentId, String firstName, String lastName, String email, LocalDate birthDate, boolean status, LocalDateTime registerDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.status = status;
        this.registerDate = registerDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && status == student.status && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(birthDate, student.birthDate) && Objects.equals(registerDate, student.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName, email, birthDate, status, registerDate);
    }
}
