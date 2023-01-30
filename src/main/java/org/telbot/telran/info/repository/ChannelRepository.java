package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.Channel;

import java.util.List;

/**
 * This is interface for storage channels in database
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    /**
     * This is the method for find all ids by channel id from unique channel ids list
     *
     * @param channelIds channel ids list of long identifiers of channels
     * @return the list of internal ids of channels
     */
    @Query("SELECT ch.id FROM Channel ch WHERE ch.groupId IN :channelIds")
    List<Long> findAllIdsByChannelIdFromUniqueChannelIdsList(@Param("channelIds") List<Long> channelIds);
}
