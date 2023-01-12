package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userId;
    @Column(name = "current_last_event_id")
    private int currentLastEventId;
    @Column(name = "user_name")
    private String userName;

    public User() {
        //
    }

    public User(int userId, int currentLastEventId, String userName) {
        this.userId = userId;
        this.currentLastEventId = currentLastEventId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCurrentLastEventId() {
        return currentLastEventId;
    }

    public void setCurrentLastEventId(int currentLastEventId) {
        this.currentLastEventId = currentLastEventId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", currentLastEventId=" + currentLastEventId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
