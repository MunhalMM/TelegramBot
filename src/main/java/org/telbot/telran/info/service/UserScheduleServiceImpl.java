package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.UserSchedule;
import org.telbot.telran.info.repository.UserScheduleRepository;

import java.util.List;

@Service
public class UserScheduleServiceImpl implements UserScheduleService {

    @Autowired
    private UserScheduleRepository userScheduleRepository;

    @Autowired
    private UserService userService;


    @Override
    public List<UserSchedule> listAllUserSchedule() {
        return userScheduleRepository.findAll();
    }

    @Override
    public UserSchedule getUserSchedule(int id) {
        return userScheduleRepository.findById(id).orElse(null);
    }

    @Override
    public UserSchedule createUserSchedule(UserSchedule userSchedule) {
        return userScheduleRepository.save(userSchedule);
    }

    @Override
    public UserSchedule updateUserSchedule(UserSchedule userSchedule) {
        if (userSchedule.getId() == 0) {
            throw new IllegalArgumentException("You entered incorrect ID for user schedule");
        }
        int userScheduleId = userSchedule.getId();
        UserSchedule entity = userScheduleRepository.findById(userScheduleId).orElse(null);
        if (entity != null) {
            entity.setUserScheduleForChannel(entity.getUserScheduleForChannel());
            userScheduleRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void deleteUserSchedule(int id) {
        userScheduleRepository.delete(getUserSchedule(id));
    }
}
