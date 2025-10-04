package com.boz.interiorroomai.repository;

import com.boz.interiorroomai.entity.JobOutputEntity;
import com.boz.interiorroomai.entity.UserCreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOutputRepository extends JpaRepository<JobOutputEntity, Long> {
}
