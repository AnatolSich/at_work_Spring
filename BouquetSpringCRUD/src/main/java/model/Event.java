package model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "eventName")
    @NotNull
    private String eventName;

    @Column(name = "eventDate")
    @NotNull
    private Date eventDate;

    @Column(name = "regDate")
    @NotNull
    private Date regDate;

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate() {
        this.regDate = new Date();
    }
}
