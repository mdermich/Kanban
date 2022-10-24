package org.tse.tdspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.tdspring.domain.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long>{

}
