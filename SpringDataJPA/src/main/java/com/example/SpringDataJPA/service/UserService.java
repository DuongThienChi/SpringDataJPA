package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
    UserEntity  findByUserNameAndUserEmail(String userName, String userEmail);
    Page<UserEntity> findAllUser(Pageable pageable);
}
