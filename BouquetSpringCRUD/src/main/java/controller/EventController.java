package controller;

import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.EventService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllEventsGet(Model model) {
        List<Event> list = eventService.geaAllEvents();
        model.addAttribute("events", list);
        return "listEvents";
    }

    @RequestMapping(value = "addEvent", method = RequestMethod.GET)
    public String addEventGet(Model model) {
        model.addAttribute("datePattern", "dd.MM.yyyy//HH:mm");
        return "addEvent";
    }

    @RequestMapping(value = "addEvent", method = RequestMethod.POST)
    public String addEventPost(@RequestParam(value = "eventName") String eventName,
                               @RequestParam(value = "eventDate") Date eventDate) {
        Event event = new Event();
        event.setEventName(eventName);
        event.setEventDate(eventDate);
        event.setRegDate();
        eventService.addEvent(event);
        return "redirect:/";
    }

    @RequestMapping(value = "updateEvent/{id}", method = RequestMethod.GET)
    public String updateEventGet(@PathVariable int id, Model model) {
        model.addAttribute("eventAttribute", eventService.getEvent(id));
        return "updateEvent";
    }

    @RequestMapping(value = "updateEvent/{id}", method = RequestMethod.POST)
    public String updateEventPost(@PathVariable int id,
                                  @RequestParam(value = "eventName") String eventName,
                                  @RequestParam(value = "eventDate") Date eventDate) {
        Event event = eventService.getEvent(id);
        event.setEventName(eventName);
        event.setEventDate(eventDate);
        eventService.updateEvent(event);
        return "redirect:/";
    }

    @RequestMapping(value = "deleteEvent/{id}", method = RequestMethod.GET)
    public String deleteEventGet(@PathVariable int id) {
        eventService.deleteEvent(id);
        return "redirect:/";
    }
}
