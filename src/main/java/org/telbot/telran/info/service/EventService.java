package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Event;

import java.util.List;

/**
 * This is interface for abstracting business logic for the event entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public interface EventService {
    /**
     * This abstract method for return list all events
     *
     * @return list all events from repository
     */
    List<Event> listAllEvent();

    /**
     * This abstract method for return event from repositora by id
     *
     * @param id long event id
     * @return event by id
     */
    Event getEvent(long id);

    /**
     * This abstract method for creating a new event entity
     *
     * @param event entity event
     * @return entity event from repository
     */
    Event createEvent(Event event);

    /**
     * This abstract method for updating entity event
     *
     * @param event entity event from repository
     * @return updated entity event
     */
    Event updateEvent(Event event);

    /**
     * This abstract method for deleting entity event from repository
     *
     * @param id exist entity event
     */
    void deleteEvent(long id);

    /**
     * This abstract method for crating new event
     */
    void createNewEvent();

    /**
     * This abstract method for getting new events by user id
     *
     * @param id user id
     * @return list all new event by user id
     */
    List<Event> getNewEventsByUser(long id);

    /**
     * This abstract method for find all event by user id
     *
     * @param userId user id
     * @return list event by user id
     */
    List<Event> findAllByUserId(long userId);
}
