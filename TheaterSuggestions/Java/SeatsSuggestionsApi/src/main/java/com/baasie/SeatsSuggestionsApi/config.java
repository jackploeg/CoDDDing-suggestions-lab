package com.baasie.SeatsSuggestionsApi;

import com.baasie.ExternalDependencies.IProvideAuditoriumLayouts;
import com.baasie.ExternalDependencies.IProvideCurrentReservations;
import com.baasie.ExternalDependencies.auditoriumlayoutrepository.AuditoriumLayoutRepository;
import com.baasie.ExternalDependencies.reservationsprovider.ReservationsProvider;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.registerModule(new GuavaModule());
        return objectMapper;
    }
}
