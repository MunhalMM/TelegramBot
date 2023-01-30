package org.telbot.telran.info.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.repository.UserChannelRepository;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * This class to implement the business logic of use_channel entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 * @see UserChannelService
 */
@Service
public class UserChannelServiceImpl implements UserChannelService {
    /**
     * Field for auto-binding a class with a user_channel repository
     */
    @Autowired
    private UserChannelRepository userChannelRepository;
    /**
     * Field for auto-binding a class with a channel service
     */
    @Autowired
    private ChannelService channelService;
    /**
     * Field for auto-binding a class with a user service
     */
    @Autowired
    private UserService userService;

    /**
     * This method returns the entire list of user_channels from the repository
     *
     * @return list user_channels entities from repository
     */
    @Override
    public List<UserChannel> listAllUserChannel() {
        return userChannelRepository.findAll();
    }

    /**
     * This method returns a user_channel from the repository by id
     *
     * @param id user_channel internal id
     * @return entity user_channel from repository or null
     * @throws IllegalArgumentException if user with this id not exist in repository
     */
    @Override
    public UserChannel getUserChannel(long id) {
        if (userChannelRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("please enter correct id");
        }
        return userChannelRepository.findById(id).orElse(null);
    }

    /**
     * This method for creating a new user_channel entity
     *
     * @param userChannel entity user_channel
     * @return saved user_channel entity in repository
     * @throws NoSuchElementException if fields for entity user_channel filled out incorrectly
     */
    @Override
    public UserChannel createUserChannel(UserChannel userChannel) {
        if (userChannel.getId() <= 0 || userChannel.getUserId() <= 0 || userChannel.getChannelId() <= 0) {
            throw new NoSuchElementException("Please enter correct data for user channel fields");
        }
        return userChannelRepository.save(userChannel);
    }

    /**
     * This method for updating a user_channel entity from repository
     *
     * @param userChannel entity user_channel from repository
     * @return updated user_channel entity
     * @throws IllegalArgumentException if user_channel entity from repository have incorrect id for user or for channel entities
     */
    @Override
    public UserChannel updateUserChannel(UserChannel userChannel) {
        if (userChannelRepository.findById(userChannel.getId()).isEmpty() || userChannelRepository.findById(userChannel.getChannelId()).isEmpty()) {
            throw new IllegalArgumentException("You entered incorrect ID for user channel");
        }
        long id = userChannel.getId();
        UserChannel entity = userChannelRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setChannelId(entity.getChannelId());
            entity.setUserId(entity.getUserId());
            userChannelRepository.save(entity);
        }
        return entity;
    }

    /**
     * This method for delete user_channel and subscription
     *
     * @param id user_channel internal id
     * @throws NoSuchElementException if incorrect id for user_channel entity
     */
    @Override
    public void deleteUserChannel(long id) {
        if (userChannelRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Object user channel not exist");
        }
        userChannelRepository.delete(getUserChannel(id));
    }

    /**
     * This method to subscribe the user to the channel
     *
     * @param user    entity user
     * @param channel entity channel
     * @throws IllegalArgumentException if user or channel internal ids incorrect
     */
    @Override
    public void addSubscription(User user, Channel channel) {
        if (userChannelRepository.findById(user.getId()).isEmpty() || userChannelRepository.findById(channel.getId()).isEmpty()) {
            throw new IllegalArgumentException("Please try again");
        }
        userChannelRepository.save(new UserChannel(user.getId(), channel.getId()));
    }

    /**
     * This method for find all channels by user
     *
     * @param user entity user
     * @return list channels by id
     * @throws IllegalArgumentException if id is incorrect
     */
    @Override
    public List<Channel> findAllChannelByUser(User user) {
        if (userChannelRepository.findById(user.getId()).isEmpty()) {
            throw new IllegalArgumentException("Please enter correct id");
        }
        List<Long> channelIds = userChannelRepository.findByUserId(user.getId()).stream()
                .map(UserChannel::getChannelId).collect(Collectors.toList());
        return channelService.listAllChannelById(channelIds);
    }

    /**
     * This method for find all user_channels by channel ids from ids list
     *
     * @param channelIds channel ids list
     * @return all user_channels from repository
     */
    @Override
    public List<UserChannel> findAllUserChannelsByChannelIdFromIdsList(List<Long> channelIds) {
        return userChannelRepository.findAllUserChannelsByChannelIdFromIdsList(channelIds);
    }

}
