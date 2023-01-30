package org.telbot.telran.info.model;

import javax.persistence.*;

/**
 * This is the entity of the message where we receive messages received from the Telegram
 *
 * @author Munhal Mammadov
 * @version 1.0
 */

@Entity
@Table(name = "message")
public class Message {
    /**
     * Unique identifier for the message,which generated automatically
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    /**
     * Title for group from bot
     */
    @Column(name = "group_title")
    private String groupTitle;
    /**
     * Unique channel id received from bot
     */
    @Column(name = "group_id")
    private long groupId;
    /**
     * Message text received from bot
     */
    @Column(name = "text")
    private String text;

    /**
     * User name received from bot
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * Unique message id from our entity message
     */
    private int messageId;
    /**
     * Private field to determine if the message is old or new
     */
    private boolean isNew = true;

    public Message() {
        //
    }

    public Message(String groupTitle, long groupId, String text, String userName) {
        this.groupTitle = groupTitle;
        this.groupId = groupId;
        this.text = text;
        this.userName = userName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public long getGroupId() {
        return groupId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", groupTitle='" + groupTitle + '\'' +
                ", groupId=" + groupId +
                ", text='" + text + '\'' +
                ", userName='" + userName + '\'' +
                ", isNew=" + isNew +
                '}';
    }
}
