package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Event;
import org.telbot.telran.info.repository.EventRepository;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> listAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        if (event.getId() == 0) {
            throw new IllegalArgumentException("You entered incorrect ID for event");
        }
        int eventId = event.getId();
        Event entity = eventRepository.findById(eventId).orElse(null);
        if (entity != null) {
            entity.setEventForChannel(entity.getEventForChannel());
            eventRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.delete(getEvent(id));
    }
}
