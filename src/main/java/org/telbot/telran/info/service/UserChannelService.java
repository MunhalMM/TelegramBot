package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;

import java.util.List;

/**
 * This is interface for abstracting business logic for the user_channel entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public interface UserChannelService {
    /**
     * This abstract method for return list all user_channels
     *
     * @return list user_channels from repository
     */
    List<UserChannel> listAllUserChannel();

    /**
     * This abstract method returns a user_channel from the repository by id
     *
     * @param id user_channel internal id
     * @return entity user_channel
     */
    UserChannel getUserChannel(long id);

    /**
     * This abstract method for creating a new user_channel entity
     *
     * @param userChannel entity user_channel
     * @return new entity user_channel
     */
    UserChannel createUserChannel(UserChannel userChannel);

    /**
     * This abstract method for updating user_channel entity
     *
     * @param userChannel entity user_channel from repository
     * @return updated entity user_channel
     */
    UserChannel updateUserChannel(UserChannel userChannel);

    /**
     * This abstract method for deleting user_channel entity by id
     *
     * @param id user_channel internal id
     */
    void deleteUserChannel(long id);

    /**
     * This abstract method for subscribe a user to a channel
     *
     * @param user    entity user
     * @param channel entity channel
     */
    void addSubscription(User user, Channel channel);

    /**
     * This abstract method for find all channel for user
     *
     * @param user entity user
     * @return list of channels
     */
    List<Channel> findAllChannelByUser(User user);

    /**
     * This abstract method for find all user_channels by channel ids from ids list
     *
     * @param channelIds channel ids list
     * @return list user_channel
     */
    List<UserChannel> findAllUserChannelsByChannelIdFromIdsList(List<Long> channelIds);

}
