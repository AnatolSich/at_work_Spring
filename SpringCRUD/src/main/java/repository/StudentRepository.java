package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {

    void addStudent(Student student);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    Student getStudent(Integer id);

    List<Student> getAllStudents();

}
