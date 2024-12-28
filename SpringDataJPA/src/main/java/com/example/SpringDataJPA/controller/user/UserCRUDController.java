package com.example.SpringDataJPA.controller.user;

import com.example.SpringDataJPA.entity.user.UserEntity;
import com.example.SpringDataJPA.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserCRUDController {

    @Autowired
    private UserService userService;

    //create User
    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity user) {
        System.out.println("Received user: " + user);
        return userService.createUser(user);
    }
    //search
    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String name, @RequestParam String email) {
        System.out.println("Received search user: " + name);
        System.out.println("Received search user: " + email);
        return userService.findByUserNameAndUserEmail(name, email);
    }
    //get
    @GetMapping("/get")
    public Page<UserEntity> getUsers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String order) {
        int pageFormat = Math.max((page - 1), 0);
        Sort.Direction direction = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sorting = Sort.by(direction, sort);
        Pageable pageable = PageRequest.of(pageFormat , size, sorting);
        return userService.findAllUser(pageable);
    }
}
