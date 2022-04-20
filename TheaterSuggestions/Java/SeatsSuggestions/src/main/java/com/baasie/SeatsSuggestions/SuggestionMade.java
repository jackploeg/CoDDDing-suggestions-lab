package com.baasie.SeatsSuggestions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public record SuggestionMade(@JsonProperty("suggestedSeats")List<Seat> suggestedSeats, @JsonProperty("partyRequested")int partyRequested, @JsonProperty("pricingCategory")PricingCategory pricingCategory) {

    public SuggestionMade(List<Seat> suggestedSeats, int partyRequested, PricingCategory pricingCategory) {
        this.suggestedSeats = ImmutableList.copyOf(suggestedSeats);
        this.partyRequested = partyRequested;
        this.pricingCategory = pricingCategory;
    }

    public List<String> seatNames() {
        return suggestedSeats.stream().sorted(Comparator.comparing(Seat::number)).map(Seat::toString).collect(Collectors.toList());
    }

    public boolean MatchExpectation() {
        return suggestedSeats.size() == partyRequested;
    }
}