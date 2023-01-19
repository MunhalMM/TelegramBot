package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "telegram_message")
public class TelegramMessage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "group_title")
    private String groupTitle;
    @Column(name = "group_id")
    private long groupId;
    @Column(name = "text")
    private String text;
    @Column(name = "user_name")
    private String userName;

    private boolean isNew = true;

    public TelegramMessage() {
        //
    }

    public TelegramMessage(String groupTitle, long groupId, String text, String userName) {
        this.groupTitle = groupTitle;
        this.groupId = groupId;
        this.text = text;
        this.userName = userName;
    }

    public TelegramMessage(long channelId, String text, String userName, String title) {
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "TelegramMessage{" +
                "id=" + id +
                ", groupTitle='" + groupTitle + '\'' +
                ", groupId=" + groupId +
                ", text='" + text + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
