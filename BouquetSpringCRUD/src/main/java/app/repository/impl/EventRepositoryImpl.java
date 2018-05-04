package app.repository.impl;

import app.model.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import app.repository.EventRepository;

import java.util.List;

@Repository
@Transactional
public class EventRepositoryImpl implements EventRepository {
    @Autowired
    private SessionFactory eventSessionFactory;

    @Override
    public Event getEvent(int id) {
        Session session = eventSessionFactory.getCurrentSession();
        return session.get(Event.class, id);
    }

    @Override
    public List<Event> geaAllEvents() {
        Session session = eventSessionFactory.getCurrentSession();
        return (List<Event>) session.createQuery("from model.Event").list();
    }

    @Override
    public void addEvent(Event event) {
        Session session = eventSessionFactory.getCurrentSession();
        session.save(event);
    }

    @Override
    public void deleteEvent(int id) {
        Session session = eventSessionFactory.getCurrentSession();
        Event existEvent = session.get(Event.class, id);
        if (existEvent != null)
            session.delete("Event", existEvent);
        else throw new RuntimeException("No event with defined id");
    }

    @Override
    public void updateEvent(Event event) {
        Session session = eventSessionFactory.getCurrentSession();
        Event existEvent = session.get(Event.class, event.getId());
        if (existEvent != null) {
            existEvent.setEventName(event.getEventName());
            existEvent.setEventDate(event.getEventDate());
            session.saveOrUpdate("Event", existEvent);
        } else throw new RuntimeException("No event with defined id");

    }
}
