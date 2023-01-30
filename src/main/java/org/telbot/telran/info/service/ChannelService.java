package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Channel;

import java.util.List;

/**
 * This is interface for abstracting business logic for the channel entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public interface ChannelService {
    /**
     * This abstract method for return list all channels
     *
     * @return list all channels
     */
    List<Channel> listAllChannel();

    /**
     * This abstract method for return list all channels by id
     *
     * @param listId list channel ids
     * @return list channel
     */
    List<Channel> listAllChannelById(List<Long> listId);

    /**
     * This abstract method for receiving channel by id
     *
     * @param id channel id
     * @return channel
     */

    Channel getChannel(long id);

    /**
     * This abstract method for creating a new channel entity
     *
     * @param channel entity channel
     * @return new channel
     */

    Channel createChannel(Channel channel);

    /**
     * This abstract method for updating channel entity
     *
     * @param channel channel from database
     * @return updating channel
     */
    Channel updateChannel(Channel channel);

    /**
     * This abstract method for deleting channel entity by id
     *
     * @param id channel id
     */

    void deleteChannel(long id);

    /**
     * This abstract method for find all ids by channel id from unique channel ids list
     *
     * @param channelIds list channel ids
     * @return list long ids
     */

    List<Long> findAllIdsByChannelIdFromUniqueChannelIdsList(List<Long> channelIds);
}
