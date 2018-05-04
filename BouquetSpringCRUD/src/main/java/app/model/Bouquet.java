package app.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.Color;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "bouquets")
public class Bouquet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "bouquetName")
    @NotNull
    private String bouquetName;

    @Column(name = "color")
    @NotNull
    private Color color;

    @Column(name = "cost")
    @NotNull
    private BigDecimal cost;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "bouquet")
    private List<OrderItem> orderItems;

    public int getId() {
        return id;
    }

    public String getBouquetName() {
        return bouquetName;
    }

    public void setBouquetName(String bouquetName) {
        this.bouquetName = bouquetName;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
