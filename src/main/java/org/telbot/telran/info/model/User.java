package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "current_last_event_id")
    private int currentLastEventId;
    @Column(name = "user_name")
    private String userName;

    public User() {
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", currentLastEventId=" + currentLastEventId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
