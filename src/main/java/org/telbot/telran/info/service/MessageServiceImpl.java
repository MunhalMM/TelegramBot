package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Message;
import org.telbot.telran.info.repository.MessageRepository;


import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository telegramMessageRepository;


    @Override
    public List<Message> findAllMessage() {
        return telegramMessageRepository.findAll();
    }

    @Override
    public Message getMessage(int id) {
        return telegramMessageRepository.findById(id).orElse(null);
    }

    @Override
    public void addMessage(long channelId, String text, String userName, String title) {
        Message telegramMessage = new Message(channelId, text, userName, title);
        telegramMessageRepository.save(telegramMessage);
    }


    @Override
    public void deleteMessage(int id) {
        telegramMessageRepository.deleteById(id);
    }
}
