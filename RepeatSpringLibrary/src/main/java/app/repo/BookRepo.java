package app.repo;

import app.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookRepo {
    @Autowired
    SessionFactory sessionFactory;

    public Book getBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> list = (List<Book>) session.createQuery("from Book").list();
        return list;
    }

    public List<Book> getBooksByStudent(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book b where b.student.id=:studentId")
                .setInteger("studentId", studentId);
        List<Book> list = (List<Book>) query.list();
        return list;
    }

    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist("Book", book);
    }

    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book existBook = session.get(Book.class, book.getId());
        existBook.setTitle(book.getTitle());
        existBook.setStudent(book.getStudent());
        session.saveOrUpdate("Book", existBook);
    }

    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete("Book", session.get(Book.class, id));
    }
}
