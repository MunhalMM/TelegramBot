package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAllMessage();

    Message getMessage(int id);

    void addMessage(long  channelId, String text, String userName, String title);

    void deleteMessage(int id);
}
