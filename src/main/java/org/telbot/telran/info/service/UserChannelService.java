package org.telbot.telran.info.service;

import org.telbot.telran.info.model.UserChannel;

import java.util.List;

public interface UserChannelService {

    List<UserChannel> listAllUserChannel();

    UserChannel getUserChannel(int id);

    UserChannel createUserChannel(UserChannel userChannel);

    UserChannel updateUserChannel(UserChannel userChannel);

    void deleteUserChannel(int id);
}
