package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.*;
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

    @Autowired
    private UserChannelService userChannelService;

    @Autowired
    private ChannelService channelService;

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

    @Override
    public List<Event> getNewEventsByUser(long id) {
        return null;
    }
}

