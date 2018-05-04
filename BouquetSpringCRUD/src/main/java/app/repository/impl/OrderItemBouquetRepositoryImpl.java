package app.repository.impl;

import app.model.OrderItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import app.repository.OrderItemBouquetRepository;

import java.util.List;

public class OrderItemBouquetRepositoryImpl implements OrderItemBouquetRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderItem> getItemsByBouquet(int id) {
        return null;
    }
}
