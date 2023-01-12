package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int eventId;

    public Event() {
        //
    }

    public Event(int eventId) {
        this.eventId = eventId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                '}';
    }
}
