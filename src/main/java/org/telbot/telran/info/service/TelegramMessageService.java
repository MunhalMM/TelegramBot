package org.telbot.telran.info.service;

import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telbot.telran.info.model.TelegramMessage;

import java.util.List;

public interface TelegramMessageService {

    List<TelegramMessage> findAllMessage();

    TelegramMessage getMessage(int id);

    void addMessage(long channelId, String text, String userName, String title);

    void deleteMessage(int id);
}
