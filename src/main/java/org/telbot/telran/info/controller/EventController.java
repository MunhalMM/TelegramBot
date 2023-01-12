package org.telbot.telran.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telbot.telran.info.model.Event;
import org.telbot.telran.info.service.EventService;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> listAllEvent() {
        return eventService.listAllEvent();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable(name = "id") int id) {
        return eventService.getEvent(id);
    }

    @PostMapping
    public void createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @GetMapping("/{id}")
    public void deleteEvent(@PathVariable(name = "id") int id) {
        eventService.deleteEvent(id);
    }

}
