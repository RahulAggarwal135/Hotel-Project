package com.hotel.user.service.UserService.controllers;

import com.hotel.user.service.UserService.entities.User;
import com.hotel.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user) {

        String Id = UUID.randomUUID().toString();
        user.setUserId(Id);
        User saveduser = userService.saveUser(user);
        return new ResponseEntity<>(saveduser, HttpStatus.CREATED);

    }

    @GetMapping("/{Id}")
    public ResponseEntity<User> getUser (@PathVariable String Id) {
        User user = userService.getUser(Id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<User>> getAllUsers () {
        List<User> userList = userService.getAllUser();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }


}
