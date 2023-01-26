package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.telbot.telran.info.model.UserChannel;

import java.util.List;


public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {
    List<UserChannel> findAllByUserId(long userId);

    @Query("SELECT uc FROM UserChannel uc WHERE uc.channelId IN :channelIds")
    List<UserChannel> findAllUserChannelsByChannelIdFromIdsList(@Param("channelIds") List<Long> channelIds);

}

