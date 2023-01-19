package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telbot.telran.info.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
