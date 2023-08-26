package com.hotel.hotel.HotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not found exception occured");
    }
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
