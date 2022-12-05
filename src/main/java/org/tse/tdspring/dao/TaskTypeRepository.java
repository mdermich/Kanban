package org.tse.tdspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.tdspring.domain.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {
}
