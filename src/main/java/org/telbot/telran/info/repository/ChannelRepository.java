package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telbot.telran.info.model.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
}
