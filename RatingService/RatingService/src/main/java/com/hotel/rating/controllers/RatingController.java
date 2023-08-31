package com.hotel.rating.controllers;

import com.hotel.rating.entities.Rating;
import com.hotel.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService service;


    @PostMapping
    public ResponseEntity<Rating> create (@RequestBody Rating rating) {
        return ResponseEntity.ok(service.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings () {
        return ResponseEntity.ok(service.getRatings());
    }


    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsbyHotelId (@PathVariable String hotelId) {
        return ResponseEntity.ok(service.getRatingbyHotelId(hotelId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsbyUserId (@PathVariable String userId) {
        return ResponseEntity.ok(service.getRatingbyUserId(userId));
    }
}
