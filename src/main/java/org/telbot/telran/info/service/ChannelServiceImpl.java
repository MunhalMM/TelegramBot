package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.repository.ChannelRepository;

import java.util.List;

/**
 * This class to implement the business logic of channel entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 * @see ChannelService
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    /**
     * Field for auto-binding a class with a channel repository
     */
    @Autowired
    private ChannelRepository channelRepository;

    /**
     * This method returns the entire list of channels from the repository
     *
     * @return list all channels
     */
    @Override
    public List<Channel> listAllChannel() {
        return channelRepository.findAll();
    }

    /**
     * This method returns the list of channels from the repository by id
     *
     * @param listId list channel ids
     * @return list all channels by id
     */
    @Override
    public List<Channel> listAllChannelById(List<Long> listId) {
        return channelRepository.findAllById(listId);
    }

    /**
     * This method returns a channel from the repository by id
     *
     * @param id long channel id
     * @return entity channel by id or null
     * @throws IllegalArgumentException if entered incorrect id
     */
    @Override
    public Channel getChannel(long id) {
        if (channelRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Incorrect id please try again");
        }
        return channelRepository.findById(id).orElse(null);
    }

    /**
     * This method for creating a new entity channel
     *
     * @param channel entity channel
     * @return saved channel in repository
     * @throws IllegalArgumentException if entered incorrect data for fields
     */
    @Override
    public Channel createChannel(Channel channel) {
        if (channel.getGroupId() == 0 || channel.getName().isEmpty()) {
            throw new IllegalArgumentException("Please enter correct data for fields");
        }
        return channelRepository.save(channel);
    }

    /**
     * This method for updating a channel entity from repository
     *
     * @param channel entity channel
     * @return updated channel
     * @throws IllegalArgumentException if entered incorrect id for channel
     */
    @Override
    public Channel updateChannel(Channel channel) {
        if (channel.getId() <= 0 || channelRepository.findById(channel.getId()).isEmpty() || channel.getName().isEmpty() || channelRepository.findById(channel.getGroupId()).isEmpty()) {
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

    /**
     * This method for deleting a channel from repository by id
     *
     * @param id channel id
     * @throws IllegalArgumentException if in repository not exist entity channel with entered id
     */
    @Override
    public void deleteChannel(long id) {
        if (channelRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Object Channel with this " + id + " does note exist");
        }
        channelRepository.delete(getChannel(id));
    }

    /**
     * This method for find all ids by channel ids from unique channel ids list
     *
     * @param channelIds list channel ids
     * @return all ids by channel ids from unique channel ids list
     */
    @Override
    public List<Long> findAllIdsByChannelIdFromUniqueChannelIdsList(List<Long> channelIds) {
        return channelRepository.findAllIdsByChannelIdFromUniqueChannelIdsList(channelIds);
    }
}
