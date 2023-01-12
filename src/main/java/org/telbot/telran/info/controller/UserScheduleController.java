package org.telbot.telran.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telbot.telran.info.model.UserSchedule;
import org.telbot.telran.info.service.UserScheduleService;

import java.util.List;

@RestController
@RequestMapping("user_schedules")
public class UserScheduleController {

    @Autowired
    private UserScheduleService userScheduleService;

    @GetMapping
    public List<UserSchedule> listAllUserSchedule() {
        return userScheduleService.listAllUserSchedule();
    }

    @GetMapping("/{id}")
    public UserSchedule getUserSchedule(@PathVariable(name = "id") int id) {
        return userScheduleService.getUserSchedule(id);
    }

    @PostMapping
    public void createUserSchedule(@RequestBody UserSchedule userSchedule) {
        userScheduleService.createUserSchedule(userSchedule);
    }

    @PutMapping
    public UserSchedule updateUserSchedule(@RequestBody UserSchedule userSchedule) {
        return userScheduleService.updateUserSchedule(userSchedule);
    }

    @GetMapping("/{id}")
    public void deleteUserSchedule(@PathVariable(name = "id") int id) {
        userScheduleService.deleteUserSchedule(id);
    }
}
