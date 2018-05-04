package app.repository.impl;

import app.model.Bouquet;
import app.model.Event;
import app.model.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import app.repository.OrderItemRepository;

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
        return (List<OrderItem>) session.createQuery("from  model.OrderItem").list();
    }

    @Override
    public void addItem(OrderItem item, int eventId, int bouquetId) {
        Session session = sessionFactory.getCurrentSession();
        Event event = session.get(Event.class, eventId);
        Bouquet bouquet = session.get(Bouquet.class,bouquetId);
        item.setEvent(event);
        item.setBouquet(bouquet);
        session.persist("OrderItem", item);
    }

    @Override
    public void updateItem(OrderItem item) {
        Session session = sessionFactory.getCurrentSession();
        // session.saveOrUpdate();
    }

    @Override
    public void deleteItem(int id) {

    }
}
