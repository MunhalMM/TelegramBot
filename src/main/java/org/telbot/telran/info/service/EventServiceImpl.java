package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Event;
import org.telbot.telran.info.model.Message;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.repository.EventRepository;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Override
    public List<Event> listAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(long id) {
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
        long eventId = event.getId();
        Event entity = eventRepository.findById(eventId).orElse(null);
        if (entity != null) {
            entity.setEventForChannel(entity.getEventForChannel());
            eventRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void deleteEvent(long id) {
        eventRepository.delete(getEvent(id));
    }

    @Scheduled(fixedRateString = "${my.fixed.delay}")
    @Override
    public void createNewEvent() {
        List<Message> messages = messageService.listAllNewMessages();
        //Get all Message
        //Get all user with channel / group
        //For every channel or group - create event for user who subscribe on this channel/group
        //new Event - store to database
    }

    @Override
    public List<Event> getNewEventsByUser(User user) {
        return null;
    }
}

