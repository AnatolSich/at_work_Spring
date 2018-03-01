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
    public void deleteStudent(int id) {
            studentRepository.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        if (student != null) {
        studentRepository.updateStudent(student);
        } else throw new RuntimeException("student is null");
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.getStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = studentRepository.getAllStudents();
        return list;
    }
}
