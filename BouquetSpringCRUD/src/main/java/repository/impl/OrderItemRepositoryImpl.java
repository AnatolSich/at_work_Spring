package repository.impl;

import model.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import repository.OrderItemRepository;

import java.util.List;

public class OrderItemRepositoryImpl implements OrderItemRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public OrderItem getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OrderItem.class, id);
    }

    @Override
    public List<OrderItem> getAllItems() {
        Session session = sessionFactory.getCurrentSession();
        return (List<OrderItem>)session.createQuery("from  model.OrderItem").list();
    }

    @Override
    public List<OrderItem> getItemsByEvent(int id) {
        Session session = sessionFactory.getCurrentSession();

        return (List<OrderItem>)session.createQuery("from  model.OrderItem where ").list();
    }

    @Override
    public List<OrderItem> getItemsByBouquet(int id) {
        return null;
    }

    @Override
    public void addItem(OrderItem item) {

    }

    @Override
    public void updateItem(OrderItem item) {

    }

    @Override
    public void deleteItem(int id) {

    }
}
