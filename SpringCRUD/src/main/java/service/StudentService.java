package service;

import model.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    Student getStudent(Integer id);

    List<Student> getAllStudents();

}
