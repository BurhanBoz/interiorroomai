package com.boz.interiorroomai.repository;

import com.boz.interiorroomai.entity.FeedbackEntity;
import com.boz.interiorroomai.entity.UserCreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
}
