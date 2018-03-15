package repository;

import model.Event;

import java.util.List;

public interface EventRepository {
    Event getEvent(int id);
    List<Event> geaAllEvents();
    void addEvent(Event event);
    void deleteEvent(int id);
    void updateEvent(Event event);
}
