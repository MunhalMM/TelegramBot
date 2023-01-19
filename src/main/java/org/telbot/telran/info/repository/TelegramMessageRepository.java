package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telbot.telran.info.model.TelegramMessage;

public interface TelegramMessageRepository extends JpaRepository<TelegramMessage, Integer> {
}
