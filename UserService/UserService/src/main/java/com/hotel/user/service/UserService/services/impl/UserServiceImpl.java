package com.hotel.user.service.UserService.services.impl;

import com.hotel.user.service.UserService.entities.Hotel;
import com.hotel.user.service.UserService.entities.Rating;
import com.hotel.user.service.UserService.entities.User;
import com.hotel.user.service.UserService.services.exceptions.ResourceNotFoundException;
import com.hotel.user.service.UserService.repositories.UserRepository;
import com.hotel.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

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
        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is not found with Id: " + userId));

        // ratings/user/{userId}


        Rating[] ratingArrayList = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+userId, Rating[].class);


        List<Rating> ratingList = Arrays.stream(ratingArrayList).toList();

        List<Rating> ratings = ratingList.stream().map(rating -> {
            ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelResponseEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratings);
        return user;
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
