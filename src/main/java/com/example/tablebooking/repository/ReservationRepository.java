package com.example.tablebooking.repository;

import com.example.tablebooking.model.dao.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByRestaurantTableId(Long reservationTableId);
}
