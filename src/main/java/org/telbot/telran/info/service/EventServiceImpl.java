package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.*;
import org.telbot.telran.info.repository.EventRepository;


import java.util.List;

/**
 * This class to implement the business logic of event entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 * @see EventService
 */
@Service
public class EventServiceImpl implements EventService {
    /**
     * Field for auto-binding a class with a event repository
     */
    @Autowired
    private EventRepository eventRepository;
    /**
     * Field for auto-binding a class with a message service
     */
    @Autowired
    private MessageService messageService;
    /**
     * Field for auto-binding a class with a user service
     */
    @Autowired
    private UserService userService;
    /**
     * Field for auto-binding a class with a user channel service
     */
    @Autowired
    private UserChannelService userChannelService;
    /**
     * Field for auto-binding a class with a channel service
     */
    @Autowired
    private ChannelService channelService;

    /**
     * This method returns the entire list of events from the repository
     *
     * @return list of events
     */
    @Override
    public List<Event> listAllEvent() {
        return eventRepository.findAll();
    }

    /**
     * This method returns a event from the repository by id
     *
     * @param id long event id
     * @return event entity by id or null
     */
    @Override
    public Event getEvent(long id) {
        return eventRepository.findById(id).orElse(null);
    }

    /**
     * This method for creating a new entity event
     *
     * @param event entity event
     * @return saved entity event in repository
     */
    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    /**
     * This method for updating a event from repository
     *
     * @param event entity event from repository
     * @return updated entity event
     * @throws IllegalArgumentException if entity event in repository not exist
     */

    @Override
    public Event updateEvent(Event event) {
        if (eventRepository.findById(event.getId()).isEmpty()) {
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

    /**
     * This method for deleting a event from repository by id
     *
     * @param id exist entity event
     * @throws IllegalArgumentException if entity event with this id in repository not exist
     */
    @Override
    public void deleteEvent(long id) {
        if (eventRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Incorrect id,please enter correct id");
        }
        eventRepository.delete(getEvent(id));
    }

    /**
     * This is a method for creating an event that runs at a time specified in application properties according to a schedule
     */
    @Scheduled(fixedRateString = "${my.fixed.delay}")
    @Override
    public void createNewEvent() {
        List<Message> messages = messageService.getMessagesAndMarkThemOld();
        if (messages.isEmpty()) {
            return;
        }
        List<Long> uniqueChannelIdsFromMessages = messages.stream().map(Message::getGroupId).distinct().toList();
        List<Long> channelIds = channelService.findAllIdsByChannelIdFromUniqueChannelIdsList(uniqueChannelIdsFromMessages);
        List<UserChannel> allUserChannelsByChannelIdFromIdsList = userChannelService
                .findAllUserChannelsByChannelIdFromIdsList(channelIds);
        String text = "Hi! You have new messages";
        allUserChannelsByChannelIdFromIdsList.forEach(userChannel -> createEvent(new Event(userChannel.getUserId(), userChannel.getChannelId(), text)));
    }

    /**
     * This method for getting new events by user id
     *
     * @param id user id
     * @return from event repository all new saved event by user id
     * @throws IllegalArgumentException if user id not exist in repository
     */
    @Override
    public List<Event> getNewEventsByUser(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Please enter correct ID for user");
        }
        List<Event> allNewEventsByUserId = eventRepository.findAllByUserId(id);
        allNewEventsByUserId.forEach(ev -> ev.setNew(false));
        return eventRepository.saveAll(allNewEventsByUserId);

    }

    /**
     * This method for find all events by user id
     *
     * @param userId user id
     * @return list events by user id from repository
     * @throws IllegalArgumentException if user id not exist in repository
     */
    @Override
    public List<Event> findAllByUserId(long userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Incorrect ID");
        }
        return eventRepository.findAllByUserId(userId);
    }

}

