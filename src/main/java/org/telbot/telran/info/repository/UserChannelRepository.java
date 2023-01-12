package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telbot.telran.info.model.UserChannel;

public interface UserChannelRepository extends JpaRepository<UserChannel, Integer> {
}
