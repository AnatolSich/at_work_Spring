package model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "bouquets")
public class Bouquet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "color")
    @NotNull
    private Color color;
    @Column(name = "cost")
    @NotNull
    private BigDecimal cost;

    @ManyToOne
    @ForeignKey(name = "eventId")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Event event;

    public int getId() {
        return id;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
