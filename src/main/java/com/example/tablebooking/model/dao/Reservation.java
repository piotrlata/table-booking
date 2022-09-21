package com.example.tablebooking.model.dao;

import com.example.tablebooking.model.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfGuests;
    @OneToOne
    private User user;
    @OneToOne
    private RestaurantTable restaurantTable;
    private ReservationStatus reservationStatus;
}
