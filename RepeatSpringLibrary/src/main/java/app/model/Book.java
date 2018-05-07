package app.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "title")
    @NotNull
    private String title;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "studentid", nullable = false)
    private Student student;

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
