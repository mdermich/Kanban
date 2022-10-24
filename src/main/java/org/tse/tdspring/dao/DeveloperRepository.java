package org.tse.tdspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tse.tdspring.domain.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>{

}
