package com.example.tablebooking.service;

public interface ReservationService {
    void bookTable(Long tableId, Integer numberOfGuests);

    void cancelReservation(Long tableId);
}
