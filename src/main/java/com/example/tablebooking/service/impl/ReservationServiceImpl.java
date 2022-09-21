package com.example.tablebooking.service.impl;

import com.example.tablebooking.model.ReservationStatus;
import com.example.tablebooking.model.TableStatus;
import com.example.tablebooking.model.dao.Reservation;
import com.example.tablebooking.model.dao.RestaurantTable;
import com.example.tablebooking.model.dao.User;
import com.example.tablebooking.repository.ReservationRepository;
import com.example.tablebooking.service.ReservationService;
import com.example.tablebooking.service.RestaurantTableService;
import com.example.tablebooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final RestaurantTableService restaurantTableService;

    @Override
    public void bookTable(Long tableId, Integer numberOfGuests) {
        User currentUser = userService.getCurrentUser();
        restaurantTableService.updateTableStatus(TableStatus.BOOKED, tableId);
        RestaurantTable table = restaurantTableService.getTable(tableId);
        Reservation reservation = new Reservation();
        reservation.setReservationStatus(ReservationStatus.RESERVED);
        reservation.setNumberOfGuests(numberOfGuests);
        reservation.setRestaurantTable(table);
        reservation.setUser(currentUser);
        reservationRepository.save(reservation);
    }

    @Override
    public void cancelReservation(Long tableId) {
        restaurantTableService.updateTableStatus(TableStatus.AVAILABLE, tableId);
        Optional<Reservation> reservationOptional = reservationRepository.findByRestaurantTableId(tableId);
        if (reservationOptional.isEmpty()) {
            throw new IllegalArgumentException("there is no reservation");
        }
        Reservation reservation = reservationOptional.get();
        reservation.setReservationStatus(ReservationStatus.CANCELED);
        reservationRepository.save(reservation);
    }
}
