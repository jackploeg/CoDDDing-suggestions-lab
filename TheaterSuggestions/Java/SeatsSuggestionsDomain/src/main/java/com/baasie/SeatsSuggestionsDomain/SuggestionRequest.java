package com.baasie.SeatsSuggestionsDomain;

import lombok.Value;

public record SuggestionRequest(int partyRequested, PricingCategory pricingCategory) {

    @Override
    public String toString() {
        return String.format("%s-%s", partyRequested, pricingCategory.toString());
    }
}