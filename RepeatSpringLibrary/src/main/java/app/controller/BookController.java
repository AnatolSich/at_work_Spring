package app.controller;

import app.model.Book;
import app.repo.BookRepo;
import app.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping (value = "/Book")
public class BookController {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    StudentRepo studentRepo;

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public String getBooksByStud(@PathVariable int studentId,
                                 Model model) {
        model.addAttribute("books", bookRepo.getBooksByStudent(studentId));
        model.addAttribute("studentId", studentId);
        return "listBooks";
    }

    @RequestMapping(value = "/add/{studentId}", method = RequestMethod.GET)
    public String add(@PathVariable int studentId,
                      Model model){
        model.addAttribute("studentId",studentId);
        return "addBook";
    }

    @RequestMapping(value = "/add/{studentId}", method = RequestMethod.POST)
    public String add(@PathVariable int studentId,
                      @RequestParam(value = "title") String title){
        Book book = new Book();
        book.setTitle(title);
        book.setStudent(studentRepo.getStudent(studentId));
        bookRepo.addBook(book);
        return "redirect:/Book/{studentId}";
    }

    @RequestMapping(value = "/update/{id}/{studentId}", method = RequestMethod.GET)
    public String update(@PathVariable int id,
                         @PathVariable int studentId,
                         Model model){
        model.addAttribute("book", bookRepo.getBook(id));
        model.addAttribute("studentId",studentId);
        return "updateBook";
    }

    @RequestMapping(value = "/update/{id}/{studentId}", method = RequestMethod.POST)
    public String update(@RequestParam(value = "title") String title,
                         @RequestParam(value = "studentId") int newStudentId,
                         @PathVariable int id,
                         @PathVariable int studentId){
        Book book = bookRepo.getBook(id);
        book.setTitle(title);
        book.setStudent(studentRepo.getStudent(newStudentId));
        bookRepo.updateBook(book);
        return "redirect:/Book/{studentId}";
    }

    @RequestMapping(value = "/delete/{id}/{studentId}", method = RequestMethod.GET)
    public String delete(@PathVariable int id,
                         @PathVariable int studentId){
        bookRepo.deleteBook(id);
        return "redirect:/Book/{studentId}";
    }

}
