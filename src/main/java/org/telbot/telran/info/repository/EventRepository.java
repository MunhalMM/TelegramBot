package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.Event;
import org.telbot.telran.info.model.User;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {
    //List<Event> getNewEventsByUser(User user);
}
