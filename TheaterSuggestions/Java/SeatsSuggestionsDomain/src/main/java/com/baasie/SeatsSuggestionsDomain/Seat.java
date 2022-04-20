package com.baasie.SeatsSuggestionsDomain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

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

    public Seat allocate() {
        if (seatAvailability == SeatAvailability.Available) {
            return new Seat(rowName, number, pricingCategory, SeatAvailability.Allocated);
        }
        return this;
    }

    public boolean sameSeatLocation(Seat seat) {
        return rowName.equals(seat.rowName) && number == seat.number;
    }

    @Override
    public String toString() {
        return rowName + number;
    }

}