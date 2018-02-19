package service.impl;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl() {
        this.studentRepository = new StudentRepositoryImpl();
    }


    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    @Override
    public Student getStudent(Integer id) {

        return studentRepository.getStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
