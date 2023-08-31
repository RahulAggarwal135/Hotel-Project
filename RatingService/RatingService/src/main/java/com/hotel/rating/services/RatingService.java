package com.hotel.rating.services;

import com.hotel.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create (Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingbyUserId (String userId);

    List<Rating> getRatingbyHotelId (String hotelId);


}
