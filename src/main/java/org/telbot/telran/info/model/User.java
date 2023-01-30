package org.telbot.telran.info.model;

import org.telbot.telran.info.configuration.BotRole;

import javax.persistence.*;

/**
 * This is one of the main entities that create users with roles to receive events from channel of group telegram
 *
 * @author Munhal Mammadov
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class User {
    /**
     * Unique identifier for the user,which generated automatically
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    /**
     * This is field to define the username
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * This is field to define the user role user or admin
     */
    @Enumerated(EnumType.STRING)
    private BotRole userRole;

    public User() {
        //
    }

    public User(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BotRole getUserRole() {
        return userRole;
    }

    public void setUserRole(BotRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
