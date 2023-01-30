package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.UserChannel;

import java.util.List;

/**
 * This is interface for storage user_channels in database
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
@Repository
public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {
    /**
     * This method for find all user_channels with user id
     *
     * @param userId internal identifier for user
     * @return list all channels for user
     */
    @Query("SELECT uc FROM UserChannel uc WHERE uc.userId = :userId")
    List<UserChannel> findByUserId(@Param("userId") long userId);

    /**
     * This method for find all user_channels by channel ids from ids list
     *
     * @param channelIds list internal identifier channel ids
     * @return list of user_channels
     */
    @Query("SELECT uc FROM UserChannel uc WHERE uc.channelId IN :channelIds")
    List<UserChannel> findAllUserChannelsByChannelIdFromIdsList(@Param("channelIds") List<Long> channelIds);

}

