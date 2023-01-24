package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "event_for_user_channel")
    private String eventForUserChannel;

    public Event() {
        //
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

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventForUserChannel='" + eventForUserChannel + '\'' +
                '}';
    }
}
