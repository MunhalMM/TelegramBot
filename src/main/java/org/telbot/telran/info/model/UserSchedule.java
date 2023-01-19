package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "user_schedule")
public class UserSchedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_schedule_for_channel")
    private int userScheduleForChannel;

    public UserSchedule() {
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserScheduleForChannel() {
        return userScheduleForChannel;
    }

    public void setUserScheduleForChannel(int userScheduleForChannel) {
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
