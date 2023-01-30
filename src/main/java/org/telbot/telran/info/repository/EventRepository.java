package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.Event;

import java.util.List;

/**
 * This is interface for storage events in database
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    /**
     * This is the list of new events by given user id
     *
     * @param userId must not be null
     * @return all new events for user
     */
    @Query("SELECT e FROM Event e WHERE e.isNew = true AND e.userId =:userId")
    List<Event> findAllByUserId(@Param("userId") long userId);
}
