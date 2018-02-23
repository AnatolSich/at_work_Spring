package service.impl;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.StudentService;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl() {
        this.studentRepository = new StudentRepositoryImpl();
    }


    @Override
    public void addStudent(Student student) {
        if (student != null) {
            studentRepository.addStudent(student);
        } else throw new RuntimeException("student is null");

    }

    @Override
    public void deleteStudent(Integer id) {
        if (id != null) {
            studentRepository.deleteStudent(id);
        } else throw new RuntimeException("id is null");
    }

    @Override
    public void updateStudent(Student student) {
        if (student != null) {
        studentRepository.updateStudent(student);
        } else throw new RuntimeException("student is null");
    }

    @Override
    public Student getStudent(Integer id) {
        if (id != null) {
        return studentRepository.getStudent(id);
        } else throw new RuntimeException("id is null");
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>)studentRepository.getAllStudents();
    }
}
