package org.telbot.telran.info.model;

import javax.persistence.*;

/**
 * This is the entity of the event which serves to create new messages for the user and admin
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
@Entity
@Table(name = "event")
public class Event {
    /**
     * Unique identifier for the event,which generated automatically
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    /**
     * User id from entity user
     */
    @Column(name = "user_id")
    private long userId;
    /**
     * Channel id from entity channel
     */
    @Column(name = "channel_id")
    private long channelId;
    @Column(name = "event_for_user_channel")
    private String eventForUserChannel;

    /**
     * This field is for changing the state of our events from new ton old
     */
    @Column(name = "is_new")
    private Boolean isNew = true;

    public Event() {
        //
    }

    public Event(long userId, long channelId, String eventForUserChannel) {
        this.userId = userId;
        this.channelId = channelId;
        this.eventForUserChannel = eventForUserChannel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventForChannel() {
        return eventForUserChannel;
    }

    public void setEventForChannel(String eventForChannel) {
        this.eventForUserChannel = eventForChannel;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getEventForUserChannel() {
        return eventForUserChannel;
    }

    public void setEventForUserChannel(String eventForUserChannel) {
        this.eventForUserChannel = eventForUserChannel;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventForUserChannel='" + eventForUserChannel + '\'' +
                '}';
    }
}
