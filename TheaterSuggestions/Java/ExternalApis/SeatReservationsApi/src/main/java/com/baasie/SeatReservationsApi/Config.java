package com.baasie.SeatReservationsApi;

import com.baasie.ExternalDependencies.IProvideCurrentReservations;
import com.baasie.ExternalDependencies.reservationsprovider.ReservationsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan("com.baasie.ExternalDependencies")
public class Config
{

    @Bean
    public IProvideCurrentReservations iProvideCurrentReservations() throws IOException {
        return new ReservationsProvider();
    }
}
