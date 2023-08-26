package com.hotel.hotel.HotelService.controllers;

import com.hotel.hotel.HotelService.entities.Hotel;
import com.hotel.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
public class HotelController {


    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel>create(@RequestBody Hotel hotel) {
        String randomid = UUID.randomUUID().toString();
        hotel.setId(randomid);
        return new ResponseEntity<>(hotelService.create(hotel), HttpStatus.CREATED);

    }

    @GetMapping("/{Id}")
    public ResponseEntity<Hotel>gethotel(@PathVariable String Id) {
        return new ResponseEntity<>(hotelService.getHotel(Id), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<Hotel>>gethotels() {
        return new ResponseEntity<>(hotelService.getAllhotels(), HttpStatus.OK);
    }

}
