package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Message;

import java.util.List;

/**
 * This is interface for abstracting business logic for the message entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public interface MessageService {
    /**
     * This abstract method for return list all messages in repository
     *
     * @return all messages from repository
     */
    List<Message> findAllMessage();

    /**
     * This abstract method for return message from repository
     *
     * @param id message id
     * @return entity message from repository
     */
    Message getMessage(long id);

    /**
     * This abstract method for adding message to database
     *
     * @param groupTitle string title for channel or group
     * @param groupId    external identifier
     * @param text       of message
     * @param userName   username
     */
    void addMessage(String groupTitle, long groupId, String text, String userName);

    /**
     * This abstract method for deleting message from repository by internal id
     *
     * @param id internal id for message
     */
    void deleteMessage(long id);

    /**
     * This abstract method for getting list all new messages from repository
     *
     * @return list new messages
     */
    List<Message> listAllNewMessages();

    /**
     * This abstract method marks read messages like old
     *
     * @return list all read messages
     */

    List<Message> getMessagesAndMarkThemOld();

}
