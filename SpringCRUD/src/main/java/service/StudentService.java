package service;

import model.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    void deleteStudent(int id);

    void updateStudent(Student student);

    Student getStudent(int id);

    List<Student> getAllStudents();

}
