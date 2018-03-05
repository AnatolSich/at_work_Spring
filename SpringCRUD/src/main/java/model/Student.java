package model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    @Basic
    private String name;

    @Column
    @NotNull
    private Boolean external;

    @Column(name = "createDate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Timestamp createDate;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String dateStr = timestamp.toString();
            Date date = format.parse(dateStr);
            dateStr = format.format(date);
            this.createDate = Timestamp.valueOf(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
