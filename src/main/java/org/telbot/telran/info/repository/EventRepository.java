package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telbot.telran.info.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
