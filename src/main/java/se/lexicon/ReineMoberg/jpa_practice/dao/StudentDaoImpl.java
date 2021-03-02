package se.lexicon.ReineMoberg.jpa_practice.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.ReineMoberg.jpa_practice.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository  //Same as @Component for injection
//@Transactional  //To handle all method transactions automatically (OBS! Spring, not Javax!)
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext //Inject entity manager in Spring
    EntityManager entityManager;

    @Override
    @Transactional  //Handle method transactions automatically (OBS! Spring, not Javax!)
    public Student create(Student student) {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    @Transactional  //Handle method transactions automatically (OBS! Spring, not Javax!)
    public Student update(Student student) {
        return null;
    }

    @Override
    @Transactional  //Handle method transactions automatically (OBS! Spring, not Javax!)
    public List<Student> saveStudents(List<Student> studentList) {
        return null;
    }
}
