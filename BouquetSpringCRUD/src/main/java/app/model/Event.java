package app.model;


//import javax.persistence.*;
import app.converter.EventDateConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
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
   // @DateTimeFormat()
    private LocalDateTime eventDate;

    @Column (name = "delivery")
    @NotNull
    private boolean delivery;

    @Column(name = "regDate")
    @NotNull
    @Convert(converter = EventDateConverter.class)
    private LocalDateTime regDate;

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

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate() {
        this.regDate = LocalDateTime.now();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
