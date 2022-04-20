package com.baasie.SeatsSuggestions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public record Seat(@JsonProperty("rowName") String rowName, @JsonProperty("number")  int number, @JsonProperty("pricingCategory")  PricingCategory pricingCategory, @JsonProperty("seatAvailability")  SeatAvailability seatAvailability) {

    public boolean isAvailable() {
        return seatAvailability == SeatAvailability.Available;
    }

    public boolean matchCategory(PricingCategory pricingCategory) {
        if (pricingCategory == PricingCategory.Mixed) {
            return true;
        }

        return this.pricingCategory == pricingCategory;
    }

    Seat allocate() {
        if (seatAvailability == SeatAvailability.Available) {
            return new Seat(rowName, number, pricingCategory, SeatAvailability.Allocated);
        }
        return this;
    }

    public boolean sameSeatLocation(Seat seat) {
        return rowName.equals(seat.rowName) && number == seat.number;
    }

    boolean isAdjacentWith(List<Seat> seats) {

        List<Seat> orderedSeats = seats.stream()
                .sorted(Comparator.comparing(Seat::number))
                .collect(Collectors.toCollection(ArrayList::new));

        for (Seat seat : orderedSeats) {
            if (number + 1 == seat.number || number - 1 == seat.number)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return rowName + number;
    }
}