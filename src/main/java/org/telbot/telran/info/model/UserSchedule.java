package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "user_schedules")
public class UserSchedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userScheduleId;

    public UserSchedule() {
        //
    }

    public UserSchedule(int userScheduleId) {
        this.userScheduleId = userScheduleId;
    }

    public int getUserScheduleId() {
        return userScheduleId;
    }

    public void setUserScheduleId(int userScheduleId) {
        this.userScheduleId = userScheduleId;
    }

    @Override
    public String toString() {
        return "UserSchedule{" +
                "userScheduleId=" + userScheduleId +
                '}';
    }
}
