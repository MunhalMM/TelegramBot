package org.telbot.telran.info.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.service.ChannelService;

import java.util.List;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public List<Channel> listAllChannel() {
        return channelService.listAllChannel();
    }

    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable(name = "id") long id) {
        return channelService.getChannel(id);
    }

    @PostMapping
    public void createChannel(@RequestBody Channel channel) {
        channelService.createChannel(channel);
    }

    @PutMapping
    public Channel updateChannel(@RequestBody Channel channel) {
        return channelService.updateChannel(channel);
    }

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable(name = "id") long id) {
        channelService.deleteChannel(id);
    }

}
