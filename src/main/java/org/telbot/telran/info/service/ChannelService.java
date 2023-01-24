package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Channel;

import java.util.List;

public interface ChannelService {

    List<Channel> listAllChannel();

    List<Channel> listAllChannelById(List<Long> listId);

    Channel getChannel(long id);

    Channel createChannel(Channel channel);

    Channel updateChannel(Channel channel);

    void deleteChannel(long id);
}
