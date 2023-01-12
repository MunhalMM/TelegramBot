package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.repository.ChannelRepository;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> listAllChannel() {
        return channelRepository.findAll();
    }

    @Override
    public Channel getChannel(int id) {
        return channelRepository.findById(id).orElse(null);
    }

    @Override
    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public Channel updateChannel(Channel channel) {
        return null;
    }

    @Override
    public void deleteChannel(int id) {
        channelRepository.deleteById(id);
    }
}
