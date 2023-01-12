package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Event;

import java.util.List;

public interface EventService {

    List<Event> listAllEvent();

    Event getEvent(int id);

    Event createEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(int id);
}
