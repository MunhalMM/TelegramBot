package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.telbot.telran.info.model.Channel;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

    @Query("SELECT ch.id FROM Channel ch WHERE ch.groupId IN :channelIds")
    List<Long> findAllIdsByChannelIdFromUniqueChannelIdsList(@Param("channelIds") List<Long> channelIds);
}
