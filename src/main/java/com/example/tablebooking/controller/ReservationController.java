package com.example.tablebooking.controller;

import com.example.tablebooking.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    @Operation(description = "book table for user", security = {@SecurityRequirement(name = "bearer"),
            @SecurityRequirement(name = "basicAuth")})
    public void bookTable(@RequestParam Long tableId, @RequestParam Integer numberOfGuests) {
        reservationService.bookTable(tableId, numberOfGuests);
    }

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    @Operation(description = "book table for user", security = {@SecurityRequirement(name = "bearer"),
            @SecurityRequirement(name = "basicAuth")})
    public void cancelReservation(@RequestParam Long tableId) {
        reservationService.cancelReservation(tableId);
    }
}
