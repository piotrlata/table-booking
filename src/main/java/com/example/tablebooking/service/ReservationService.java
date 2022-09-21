package com.example.tablebooking.service;

public interface ReservationService {
    Boolean bookTable(Long tableId, Integer numberOfGuests);

    Boolean cancelReservation(Long tableId);
}
