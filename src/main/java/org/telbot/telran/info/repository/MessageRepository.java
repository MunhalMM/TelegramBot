package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.telbot.telran.info.model.Message;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT a FROM Message a WHERE a.isNew = true")
    List<Message> findAllNewMessages();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Message m SET m.isNew = false WHERE m.id IN :messageIds")
    void changeIsNewToFalse(@Param("messageIds") List<Long> messageIds);
}
