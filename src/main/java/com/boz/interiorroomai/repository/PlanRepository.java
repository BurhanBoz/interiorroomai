package com.boz.interiorroomai.repository;

import com.boz.interiorroomai.entity.PlanEntity;
import com.boz.interiorroomai.entity.UserCreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}
