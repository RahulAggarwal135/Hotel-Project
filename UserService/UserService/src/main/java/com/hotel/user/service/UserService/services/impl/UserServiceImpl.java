package com.hotel.user.service.UserService.services.impl;

import com.hotel.user.service.UserService.entities.User;
import com.hotel.user.service.UserService.services.exceptions.ResourceNotFoundException;
import com.hotel.user.service.UserService.repositories.UserRepository;
import com.hotel.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is not found with Id: " + userId));
    }

    @Override
    public User updateUser(User user, String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is not found with Id: " + userId));
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is not found with Id" + userId));
        userRepository.delete(user);
    }
}
