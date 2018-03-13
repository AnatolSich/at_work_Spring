package model;


import converter.DateConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Constants.Constants.DATE_PATTERN;

@Entity
@Table(name = "students")
public class Student  implements Serializable{
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
    @Convert (converter = DateConverter.class)
    private Date createDate;

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

    public Date getCreateDate() {
        return createDate;
    }
}
