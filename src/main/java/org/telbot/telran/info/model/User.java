package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "current_last_event_id")
    private long currentLastEventId;
    @Column(name = "user_name")
    private String userName;

    public User() {
        //
    }

    public User(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCurrentLastEventId() {
        return currentLastEventId;
    }

    public void setCurrentLastEventId(long currentLastEventId) {
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
