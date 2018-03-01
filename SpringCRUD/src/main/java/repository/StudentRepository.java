package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {

    void addStudent(Student student);

    void deleteStudent(int id);

    void updateStudent(Student student);

    Student getStudent(int id);

    List<Student> getAllStudents();

}
