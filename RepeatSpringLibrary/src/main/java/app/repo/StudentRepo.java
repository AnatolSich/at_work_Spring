package app.repo;

import app.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentRepo {

    @Autowired
    SessionFactory sessionFactory;

    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> list = (List<Student>) session.createQuery("from Student").list();
        return list;
    }

    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist("Student", student);
    }

    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student existStudent = session.get(Student.class, student.getId());
        existStudent.setName(student.getName());
        existStudent.setList(student.getList());
        session.saveOrUpdate("Student", existStudent);
    }

    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete("Student", session.get(Student.class, id));
    }

}
