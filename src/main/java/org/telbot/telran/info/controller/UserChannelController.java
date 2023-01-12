package org.telbot.telran.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.service.UserChannelService;

import java.util.List;

@RestController
@RequestMapping("user_channels")
public class UserChannelController {

    @Autowired
    private UserChannelService userChannelService;


    @GetMapping
    public List<UserChannel> listAllUserChannel() {
        return userChannelService.listAllUserChannel();
    }

    @GetMapping("/{id}")
    public UserChannel getUserChannel(@PathVariable(name = "id") int id) {
        return userChannelService.getUserChannel(id);
    }

    @PostMapping
    public void createUserChannel(@RequestBody UserChannel userChannel) {
        userChannelService.createUserChannel(userChannel);
    }

    @PutMapping
    public UserChannel updateUserChannel(@RequestBody UserChannel userChannel) {
        return userChannelService.updateUserChannel(userChannel);
    }

    @GetMapping("/{id}")
    public void deleteUserChannel(@PathVariable(name = "id") int id) {
        userChannelService.deleteUserChannel(id);
    }
}
