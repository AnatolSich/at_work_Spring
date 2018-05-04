package app.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import app.model.Bouquet;
import app.model.Event;

@Entity (name = "OrderItem")
@Table (name = "order_items")
public class OrderItem {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id",nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Event event;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "id",nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bouquet bouquet;

    @Column (name = "quantity")
    private int quantity;

    public int getId() {
        return id;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Bouquet getBouquet() {
        return bouquet;
    }

    public void setBouquet(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
