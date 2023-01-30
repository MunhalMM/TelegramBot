package org.telbot.telran.info.model;

import javax.persistence.*;

/**
 * This is entity class Channel,which contains dta received from the bot for use in our program
 * @author Munhal Mammadov
 * @version 1.0
 */
@Entity
@Table(name = "channel")
public class Channel {
    /**
     * Unique identifier for the Channel,which generated automatically
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    /**
     * Channel name received from bot
     */
    @Column(name = "name")
    private String name;
    /**
     * Unique Channel id received from bot
     */
    @Column(name = "group_id")
    private long groupId;

    public Channel() {
        //
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }


    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
