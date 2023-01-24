package org.telbot.telran.info.service;

import org.telbot.telran.info.model.UserSchedule;

import java.util.List;

public interface UserScheduleService {

    List<UserSchedule> listAllUserSchedule();

    UserSchedule getUserSchedule(long id);

    UserSchedule createUserSchedule(UserSchedule userSchedule);

    UserSchedule updateUserSchedule(UserSchedule userSchedule);

    void deleteUserSchedule(long id);
//
//    void addScheduleToUser(int userScheduleId, int userId);
//
//    void removeScheduleFromUser(int userScheduleId, int userId);
}
