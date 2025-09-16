package com.boz.interiorroomai.repository;

import com.boz.interiorroomai.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    UserEntity findByUserName(String userName);
    UserEntity findByEmail(String email);
}
