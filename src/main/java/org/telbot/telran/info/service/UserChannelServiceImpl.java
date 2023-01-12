package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.repository.UserChannelRepository;

import java.util.List;
@Service
public class UserChannelServiceImpl implements UserChannelService {

    @Autowired
    private UserChannelRepository userChannelRepository;

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
        return null;
    }

    @Override
    public void deleteUserChannel(int id) {
        userChannelRepository.deleteById(id);
    }
}
