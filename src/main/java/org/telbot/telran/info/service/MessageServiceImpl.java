package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Message;
import org.telbot.telran.info.repository.MessageRepository;


import java.util.List;

/**
 * This class to implement the business logic of message entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 * @see MessageService
 */
@Service
public class MessageServiceImpl implements MessageService {
    /**
     * Field for auto-binding a class with a message repository
     */
    @Autowired
    private MessageRepository telegramMessageRepository;

    /**
     * This method returns the entire list of messages from the repository
     *
     * @return list messages from repository
     */
    @Override
    public List<Message> findAllMessage() {
        return telegramMessageRepository.findAll();
    }

    /**
     * This method returns a message from the repository by id
     *
     * @param id message id
     * @return entity message or null from repository
     * @throws IllegalArgumentException if entered incorrect internal id
     */
    @Override
    public Message getMessage(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Incorrect id");
        }
        return telegramMessageRepository.findById(id).orElse(null);
    }

    /**
     * This method adding message to repository
     *
     * @param groupTitle string title for channel or group
     * @param groupId    external identifier
     * @param text       of message
     * @param userName   username
     */
    @Override
    public void addMessage(String groupTitle, long groupId, String text, String userName) {
        Message telegramMessage = new Message(groupTitle, groupId, text, userName);
        telegramMessageRepository.save(telegramMessage);
    }

    /**
     * This method for deleting message from repository by id
     *
     * @param id internal id for message
     */
    @Override
    public void deleteMessage(long id) {
        telegramMessageRepository.deleteById(id);
    }

    /**
     * This method return list all new messages from repository
     *
     * @return list new messages from repository
     */
    @Override
    public List<Message> listAllNewMessages() {
        return telegramMessageRepository.findAllNewMessages();
    }

    /**
     * This method marks read messages like old
     *
     * @return list read messages
     */
    @Override
    public List<Message> getMessagesAndMarkThemOld() {
        List<Message> messages = telegramMessageRepository.findAllNewMessages();
        if (!messages.isEmpty()) {
            List<Long> idsList = messages.stream().map(Message::getId).toList();
            telegramMessageRepository.changeIsNewToFalse(idsList);
        }
        return messages;
    }
}
