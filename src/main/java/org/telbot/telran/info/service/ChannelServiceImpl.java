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
    public List<Channel> listAllChannelById(List<Long> listId) {
        return channelRepository.findAllById(listId);
    }

    @Override
    public Channel getChannel(long id) {
        return channelRepository.findById(id).orElse(null);
    }

    @Override
    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public Channel updateChannel(Channel channel) {
        if (channel.getId() == 0) {
            throw new IllegalArgumentException("You entered incorrect ID for channel");
        }
        long channelId = channel.getId();
        Channel entity = channelRepository.findById(channelId).orElse(null);
        if (entity != null) {
            entity.setName(entity.getName());
            entity.setGroupId(entity.getGroupId());
            channelRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void deleteChannel(long id) {
        channelRepository.delete(getChannel(id));
    }
}
