package app.model;


//import javax.persistence.*;
import app.converter.EventDateConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @Convert(converter = EventDateConverter.class)
    private Date eventDate;

    @Column (name = "delivery")
    @NotNull
    private boolean delivery;

    @Column(name = "regDate")
    @NotNull
    @Convert(converter = EventDateConverter.class)
    private Date regDate;

    //mappedBy указывает на поле в классе OrderItem по которому проверяется,
    // попадет ли экземпляр класса OrderItem в List
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "event")
    private List<OrderItem> orderItems;

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

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate() {
        this.regDate = new Date();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
