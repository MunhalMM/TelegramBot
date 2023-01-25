package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.telbot.telran.info.model.Message;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Long> {

   @Query("SELECT a FROM Message a WHERE a.isNew = true")
   List<Message> findAllNewMessages();
}
