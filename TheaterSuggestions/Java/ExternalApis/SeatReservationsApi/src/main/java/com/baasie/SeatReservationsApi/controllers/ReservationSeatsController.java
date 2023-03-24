package com.baasie.SeatReservationsApi.controllers;


import lombok.RequiredArgsConstructor;

import com.baasie.ExternalDependencies.IProvideCurrentReservations;
import com.baasie.ExternalDependencies.reservationsprovider.ReservedSeatsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/data_for_reservation_seats")
@RequiredArgsConstructor
public class ReservationSeatsController {

    private final IProvideCurrentReservations provideCurrentReservations;

    // GET api/data_for_reservation_seats/5
    @GetMapping(value = "/{showId}", produces = "application/json")
    public ReservedSeatsDto get(@PathVariable String showId) {
        return provideCurrentReservations.getReservedSeats(showId);
    }
}
