package app.controller;

import app.model.Student;
import app.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/Student")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

   /* @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("students", studentRepo.getAllStudents());
        return "listStudents";
    }*/

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(){
        return "addStudent";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "name") String name){
        Student student = new Student();
        student.setName(name);
        studentRepo.addStudent(student);
        return "redirect:/";
    }

     @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id,
                         Model model){
        model.addAttribute("student", studentRepo.getStudent(id));
        return "updateStudent";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@RequestParam(value = "name") String name,
                         @PathVariable int id){
        Student student = studentRepo.getStudent(id);
        student.setName(name);
        studentRepo.updateStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        studentRepo.deleteStudent(id);
        return "redirect:/";
    }


}
