package org.tse.tdspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tse.tdspring.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
