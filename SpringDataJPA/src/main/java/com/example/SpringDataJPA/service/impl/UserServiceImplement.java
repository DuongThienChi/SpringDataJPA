package com.example.SpringDataJPA.service.impl;

import com.example.SpringDataJPA.entity.user.UserEntity;
import com.example.SpringDataJPA.repository.UserRepository;
import com.example.SpringDataJPA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public UserEntity findByUserNameAndUserEmail(String userName, String userEmail) {
        UserEntity a =  userRepository.findByUserName(userName);
        return a;
    }
    @Override
    public Page<UserEntity> findAllUser(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
