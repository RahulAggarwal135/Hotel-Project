package com.hotel.hotel.HotelService.services.Impl;

import com.hotel.hotel.HotelService.entities.Hotel;
import com.hotel.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.hotel.hotel.HotelService.services.HotelService;
import com.hotel.hotel.HotelService.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllhotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {

        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel Id not found with Id :" +id));
    }

    @Override
    public void deleteHotel(String Id) {

    }
}
