package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.repository.UserChannelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserChannelServiceImpl implements UserChannelService {

    @Autowired
    private UserChannelRepository userChannelRepository;

    @Autowired
    private ChannelService channelService;

    @Override
    public List<UserChannel> listAllUserChannel() {
        return userChannelRepository.findAll();
    }

    @Override
    public UserChannel getUserChannel(long id) {
        return userChannelRepository.findById(id).orElse(null);
    }

    @Override
    public UserChannel createUserChannel(UserChannel userChannel) {
        return userChannelRepository.save(userChannel);
    }

    @Override
    public UserChannel updateUserChannel(UserChannel userChannel) {
        if (userChannel.getId() == 0) {
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

    @Override
    public void deleteUserChannel(long id) {
        userChannelRepository.delete(getUserChannel(id));
    }

    @Override
    public void addSubscription(User user, Channel channel) {
        userChannelRepository.save(new UserChannel(user.getId(), channel.getId()));
    }

    @Override
    public List<Channel> findAllChannelByUser(User user) {
        List<Long> channelIds = userChannelRepository.findAllByUserId(user.getId()).stream()
                .map(UserChannel::getChannelId).collect(Collectors.toList());
        return channelService.listAllChannelById(channelIds);
    }

    @Override
    public List<UserChannel> findAllUserChannelsByChannelIdFromIdsList(List<Long> channelIds) {
        return userChannelRepository.findAllUserChannelsByChannelIdFromIdsList(channelIds);
    }

}
