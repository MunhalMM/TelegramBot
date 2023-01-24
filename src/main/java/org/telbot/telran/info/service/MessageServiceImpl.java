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
    public Message getMessage(long id) {
        return telegramMessageRepository.findById(id).orElse(null);
    }


    @Override
    public void addMessage(String groupTitle, long groupId, String text, String userName) {
        Message telegramMessage = new Message(groupTitle, groupId, text, userName);
        telegramMessageRepository.save(telegramMessage);
    }


    @Override
    public void deleteMessage(long id) {
        telegramMessageRepository.deleteById(id);
    }

    @Override
    public List<Message> listAllNewMessages() {
        return telegramMessageRepository.findAllNewMessages();
    }
}
