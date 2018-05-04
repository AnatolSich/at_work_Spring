package app.repository.impl;

import app.model.OrderItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import app.repository.OrderItemEventRepository;

import java.util.List;

public class OrderItemEventRepositoryImpl implements OrderItemEventRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<OrderItem> getItemsByEvent(int eventId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from  model.OrderItem item where item.eventId: eventId");
        return (List<OrderItem>)query.setInteger("eventId",eventId).list();
    }
}
