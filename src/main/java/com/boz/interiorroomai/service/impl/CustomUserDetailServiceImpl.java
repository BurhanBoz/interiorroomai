package com.boz.interiorroomai.service.impl;

import com.boz.interiorroomai.dto.UserDto;
import com.boz.interiorroomai.entity.UserEntity;
import com.boz.interiorroomai.mapper.UserMapper;
import com.boz.interiorroomai.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomUserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        return new User(user.getEmail(), user.getPasswordHash(), new ArrayList<>());
    }

    public UserDto loadUserByUserName(String userName) {
        return userMapper.toDto(userRepository.findByUserName(userName));
    }
}
