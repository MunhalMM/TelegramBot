package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.telbot.telran.info.model.Message;

import java.util.List;

/**
 * This is interface for storage messages in database
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    /**
     * This method select all new messages from database,which is new
     *
     * @return list all new messages
     */
    @Query("SELECT a FROM Message a WHERE a.isNew = true")
    List<Message> findAllNewMessages();

    /**
     * This method to change all read messages from new to old
     *
     * @param messageIds list message ids
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Message m SET m.isNew = false WHERE m.id IN :messageIds")
    void changeIsNewToFalse(@Param("messageIds") List<Long> messageIds);
}
