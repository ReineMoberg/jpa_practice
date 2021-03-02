package se.lexicon.ReineMoberg.jpa_practice.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.ReineMoberg.jpa_practice.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository  //Same as @Component for injection
//@Transactional  //To handle all method transactions automatically (OBS! Spring, not Javax!)
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext //Inject entity manager in Spring
    EntityManager entityManager;

    @Override
    @Transactional  //Handle method transactions automatically (OBS! Spring, not Javax!)
    public Student create(Student student) {
        entityManager.persist(student); //Same as save or create
        return student;
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        Query query = entityManager.createQuery("Select s from Student s"); //Java Persistence query language (JPQL),
        List<Student> studentList = query.getResultList();                     //can be set to MySQL if wanted
        return studentList;
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        Query query = entityManager.createQuery("select s from Student s where s.firstName = :firstName");
        query.setParameter("firstName", firstName);
        List<Student> studentList = query.getResultList();
        return studentList;
    }

    @Override
    public void remove(int id) {
        Student student = findById(id);
        entityManager.remove(student);  //Remove is same as delete
    }

    @Override
    @Transactional  //Handle method transactions automatically (OBS! Spring, not Javax!)
    public Student update(Student student) {
        return entityManager.merge(student);    //Merge is same as update
    }

    @Override
    @Transactional  //Handle method transactions automatically (OBS! Spring, not Javax!)
    public List<Student> saveStudents(List<Student> studentList) {
        for (Student student : studentList) {
            create(student);
        }
        return studentList;
    }
}
