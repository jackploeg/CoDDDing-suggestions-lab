package com.baasie.SeatsSuggestionsApi;

import com.baasie.ExternalDependencies.IProvideAuditoriumLayouts;
import com.baasie.ExternalDependencies.IProvideCurrentReservations;
import com.baasie.ExternalDependencies.auditoriumlayoutrepository.AuditoriumLayoutRepository;
import com.baasie.ExternalDependencies.reservationsprovider.ReservationsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan("com.baasie.SeatsSuggestionsDomain")
public class config {

    @Bean
    public IProvideAuditoriumLayouts iProvideAuditoriumLayouts() throws IOException {
        return new AuditoriumLayoutRepository();
    }

    @Bean
    public IProvideCurrentReservations iProvideCurrentReservations() throws IOException {
        return new ReservationsProvider();
    }
}
