package service.impl;

import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventRepository;
import service.EventService;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event getEvent(int id) {
        if (id != 0)
            return eventRepository.getEvent(id);
        else throw new RuntimeException("Invalid value id=0");
    }

    @Override
    public List<Event> geaAllEvents() {
        return eventRepository.geaAllEvents();
    }

    @Override
    public void addEvent(Event event) {
        if (event != null)
            eventRepository.addEvent(event);
        else throw new RuntimeException("Adding event is null");
    }

    @Override
    public void deleteEvent(int id) {
        if (id != 0)
            eventRepository.deleteEvent(id);
        else throw new RuntimeException("Invalid value id=0");
    }

    @Override
    public void updateEvent(Event event) {
        if (event != null)
            eventRepository.updateEvent(event);
        else throw new RuntimeException("Updating event is null");
    }
}
