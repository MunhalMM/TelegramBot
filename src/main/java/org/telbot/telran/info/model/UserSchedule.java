package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "user_schedule")
public class UserSchedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_schedule_for_channel")
    private long userScheduleForChannel;

    public UserSchedule() {
        //
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserScheduleForChannel() {
        return userScheduleForChannel;
    }

    public void setUserScheduleForChannel(long userScheduleForChannel) {
        this.userScheduleForChannel = userScheduleForChannel;
    }

    @Override
    public String toString() {
        return "UserSchedule{" +
                "id=" + id +
                ", userId=" + userId +
                ", userScheduleForChannel=" + userScheduleForChannel +
                '}';
    }
}
