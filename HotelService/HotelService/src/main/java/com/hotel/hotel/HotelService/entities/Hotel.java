package com.hotel.hotel.HotelService.entities;
//import javax.persistence.*;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    private String id;
    String name;
    String location;
    String about;
}
