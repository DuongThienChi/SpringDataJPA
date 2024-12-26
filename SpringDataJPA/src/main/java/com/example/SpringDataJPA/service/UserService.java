package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.entity.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
    UserEntity  findByUserNameAndUserEmail(String userName, String userEmail);
}
