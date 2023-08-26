package com.hotel.hotel.HotelService.repositories;

import com.hotel.hotel.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
