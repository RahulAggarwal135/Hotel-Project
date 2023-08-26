package com.hotel.hotel.HotelService.services;

import com.hotel.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel create (Hotel hotel) ;


    List<Hotel> getAllhotels ();

    Hotel getHotel(String id);

    void deleteHotel(String Id);


}
