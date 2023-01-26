package org.telbot.telran.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.service.ChannelService;
import org.telbot.telran.info.service.UserChannelService;
import org.telbot.telran.info.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user_channels")
public class UserChannelController {

    @Autowired
    private UserChannelService userChannelService;

    @Autowired
    private UserService userService;

    @Autowired
    private ChannelService channelService;


    @GetMapping
    public List<UserChannel> listAllUserChannel() {
        return userChannelService.listAllUserChannel();
    }

    @GetMapping("/{id}")
    public UserChannel getUserChannel(@PathVariable(name = "id") long id) {
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

    @DeleteMapping("/{id}")
    public void deleteUserChannel(@PathVariable(name = "id") long id) {
        userChannelService.deleteUserChannel(id);
    }

    @PostMapping("/{userId}/{channelId}")
    public void addSubscription(@PathVariable(name = "userId") long userId, @PathVariable(name = "channelId") long channelId) {
        userChannelService.addSubscription(userService.getUser(userId), channelService.getChannel(channelId));
    }

    @GetMapping("/{userId}")
    public List<Channel> findAllChannelByUser(@PathVariable(name = "userId") long userId) {
        return userChannelService.findAllChannelByUser(userService.getUser(userId));
    }

}
