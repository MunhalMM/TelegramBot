package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.User;
/**
 * This is interface for storage user in database
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
