package se.lexicon.ReineMoberg.jpa_practice.dao;

import se.lexicon.ReineMoberg.jpa_practice.entity.Student;

import java.util.List;

//CRUD operations
public interface StudentDao {

    Student create(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void remove(int id);

    Student update(Student student);

    List<Student> saveStudents(List<Student> studentList);

    //Update status, etc.....
}
