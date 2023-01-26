package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Event;

import java.util.List;

public interface EventService {

    List<Event> listAllEvent();

    Event getEvent(long id);

    Event createEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(long id);

    void createNewEvent();

    List<Event> getNewEventsByUser(long id);
}
