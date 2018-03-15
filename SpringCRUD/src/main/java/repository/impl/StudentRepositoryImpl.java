package repository.impl;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

import java.util.List;

@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student existStudent = session.get(Student.class, id);
        if (existStudent != null) {
            session.delete(existStudent);
        } else throw new RuntimeException("No student with defined id");
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student existStudent = session.get(Student.class, student.getId());
        if (existStudent != null) {
        existStudent.setName(student.getName());
        existStudent.setExternal(student.getExternal());
        session.saveOrUpdate(existStudent);
        } else throw new RuntimeException("No student with defined id");
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Student>)session.createQuery("from Student").list();
    }
}
