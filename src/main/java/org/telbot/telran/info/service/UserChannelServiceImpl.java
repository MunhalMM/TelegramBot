package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.repository.ChannelRepository;
import org.telbot.telran.info.repository.UserChannelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserChannelServiceImpl implements UserChannelService {

    @Autowired
    private UserChannelRepository userChannelRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<UserChannel> listAllUserChannel() {
        return userChannelRepository.findAll();
    }

    @Override
    public UserChannel getUserChannel(int id) {
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
        int id = userChannel.getId();
        UserChannel entity = userChannelRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setChannelId(entity.getChannelId());
            entity.setUserId(entity.getUserId());
            userChannelRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void deleteUserChannel(int id) {
        userChannelRepository.delete(getUserChannel(id));
    }

    @Override
    public void addSubscription(User user, Channel channel) {
        userChannelRepository.save(new UserChannel(user.getId(), channel.getId()));
    }

    @Override
    public List<Channel> findAllChannelByUser(User user) {
        List<Integer> channelIds = userChannelRepository.findAllByUserId(user.getId()).stream()
                .map(UserChannel::getChannelId).collect(Collectors.toList());
        return channelRepository.findAllById(channelIds);
    }

    @Override
    public boolean isTheBotActiveOrNot(User user) {
        return false;// here will be the code to on/off the bot
    }

}
