package com.baasie.ExternalDependencies.reservationsprovider;

import com.baasie.ExternalDependencies.IProvideCurrentReservations;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ReservationsProvider implements IProvideCurrentReservations {

    private final Map<String, ReservedSeatsDto> repository = new HashMap<>();

    public ReservationsProvider() throws IOException {

        String jsonDirectoryForUnittest = Paths.get(System.getProperty("user.dir")).getParent().getParent().getParent().toString() + "/Stubs/AuditoriumLayouts";
        String jsonDirectoryForBoot = Paths.get(System.getProperty("user.dir")).getParent().getParent().toString() + "/Stubs/AuditoriumLayouts";
        Path pathToFiles;
        if(Files.exists(Paths.get(jsonDirectoryForBoot))) {
            pathToFiles = Paths.get(jsonDirectoryForBoot);
        } else {
            pathToFiles = Paths.get(jsonDirectoryForUnittest);
        }
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathToFiles);
        for (Path path : directoryStream) {
            if (path.toString().contains("_booked_seats.json")) {
                String fileName = path.getFileName().toString();
                ObjectMapper mapper = new ObjectMapper().registerModule(new GuavaModule());
                repository.put(fileName.split("-")[0], mapper.readValue(path.toFile(), ReservedSeatsDto.class));
            }

        }
    }

    public ReservedSeatsDto getReservedSeats(String showId) {
        if (repository.containsKey(showId)) {
            return repository.get(showId);
        }
        return new ReservedSeatsDto();
    }
}