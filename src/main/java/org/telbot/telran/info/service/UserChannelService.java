package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;

import java.util.List;

public interface UserChannelService {

    List<UserChannel> listAllUserChannel();

    UserChannel getUserChannel(long id);

    UserChannel createUserChannel(UserChannel userChannel);

    UserChannel updateUserChannel(UserChannel userChannel);

    void deleteUserChannel(long id);

    void addSubscription(User user, Channel channel);

    List<Channel> findAllChannelByUser(User user);

    boolean isTheBotActiveOrNot(User user);
}
