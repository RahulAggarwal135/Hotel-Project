package com.hotel.rating.services.impl;

import com.hotel.rating.entities.Rating;
import com.hotel.rating.repository.RatingRepository;
import com.hotel.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository repository;

    @Override
    public Rating create(Rating rating) {

        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingbyUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingbyHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
