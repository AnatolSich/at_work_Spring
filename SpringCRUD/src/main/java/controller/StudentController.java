package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.GET)
    public String addStudent() {
        return "addStudent";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestParam(value = "name") String name,
                             @RequestParam(value = "isExternal", defaultValue = "false") Boolean isExternal) {
        Student student = new Student();
        student.setName(name);
        student.setExternal(isExternal);
        studentService.addStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "deleteStudent/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.GET)
    public String updateStudentGet(@PathVariable Integer id, Model model) {
        model.addAttribute("studentAttribute",studentService.getStudent(id));
        return "updateStudent";
    }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.POST)
    public String updateStudentPost(@PathVariable Integer id,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "isExternal") Boolean isExternal) {
        Student student = studentService.getStudent(id);
        student.setName(name);
        student.setExternal(isExternal);
        studentService.updateStudent(student);
        return "redirect:/";
    }

}
