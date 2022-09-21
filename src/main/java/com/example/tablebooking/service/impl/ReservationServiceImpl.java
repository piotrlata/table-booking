package com.example.tablebooking.service.impl;

import com.example.tablebooking.model.ReservationStatus;
import com.example.tablebooking.model.TableStatus;
import com.example.tablebooking.model.dao.Reservation;
import com.example.tablebooking.repository.ReservationRepository;
import com.example.tablebooking.service.ReservationService;
import com.example.tablebooking.service.RestaurantTableService;
import com.example.tablebooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final RestaurantTableService restaurantTableService;

    @Override
    public Boolean bookTable(Long tableId, Integer numberOfGuests) {
        var currentUser = userService.getCurrentUser();
        restaurantTableService.updateTableStatus(TableStatus.BOOKED, tableId);
        var table = restaurantTableService.getTable(tableId);
        if (table.getNumberOfSeats() < numberOfGuests) {
            throw new IllegalArgumentException("not enough seats");
        }
        var reservation = new Reservation();
        reservation.setReservationStatus(ReservationStatus.RESERVED);
        reservation.setNumberOfGuests(numberOfGuests);
        reservation.setRestaurantTable(table);
        reservation.setUser(currentUser);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public Boolean cancelReservation(Long tableId) {
        restaurantTableService.updateTableStatus(TableStatus.AVAILABLE, tableId);
        var reservationOptional = reservationRepository.findByRestaurantTableId(tableId);
        if (reservationOptional.isEmpty()) {
            throw new IllegalArgumentException("there is no reservation");
        }
        var reservation = reservationOptional.get();
        reservation.setReservationStatus(ReservationStatus.CANCELED);
        reservationRepository.save(reservation);
        return true;
    }
}
