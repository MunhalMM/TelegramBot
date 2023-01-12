package org.telbot.telran.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telbot.telran.info.model.UserSchedule;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Integer> {
}
