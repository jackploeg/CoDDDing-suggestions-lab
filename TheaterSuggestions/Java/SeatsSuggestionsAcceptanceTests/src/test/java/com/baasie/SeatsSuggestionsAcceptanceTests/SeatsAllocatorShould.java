package com.baasie.SeatsSuggestionsAcceptanceTests;

import org.junit.Assert;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class SeatsAllocatorShould {
    /*
     *  Business Rule - Only Suggest available seats
     */
    @Test
    public void should_suggest_one_seat_when_Auditorium_contains_one_available_seat_only() {
        // Example 1 - Happy path
        //
        // * Party 1
        //
        // * Ford Auditorium-1
        //
        //       1   2   3   4   5   6   7   8   9  10
        //  A : (2) (2)  1  (1) (1) (1) (1) (1) (2) (2)
        //  B : (2) (2) (1) (1) (1) (1) (1) (1) (2) (2)
        //
        // => A3

//        final String showId = "1";
//        final int partyRequested = 1;
//
//        AuditoriumSeatingAdapter auditoriumLayoutAdapter =
//                new AuditoriumSeatingAdapter(new AuditoriumLayoutRepository(), new ReservationsProvider());
//
//        SeatAllocator seatAllocator = new SeatAllocator(auditoriumLayoutAdapter);
//
//        SuggestionMade suggestionMade = seatAllocator.makeSuggestion(showId, partyRequested);
//
//        assertThat(suggestionMade.suggestedSeats()).hasSize(1);
//        assertThat(suggestionMade.suggestedSeats().get(0).toString()).isEqualTo("A3");

        Assert.fail("NOT IMPLEMENTED YET");

    }

    @Test
    public void should_return_SeatsNotAvailable_when_Auditorium_has_all_its_seats_already_reserved() {
        // Example 2 - Unhappy path
        //
        // * Party 1
        //
        // * Madison Auditorium-5
        //      1   2   3   4   5   6   7   8   9  10
        // A : (2) (2) (1) (1) (1) (1) (1) (1) (2) (2)
        // B : (2) (2) (1) (1) (1) (1) (1) (1) (2) (2)
        //
        // => SuggestionNotAvailable

        Assert.fail("NOT IMPLEMENTED YET");
    }
}
