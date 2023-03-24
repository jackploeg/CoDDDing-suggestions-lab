package com.baasie.ExternalDependencies.auditoriumlayoutrepository;

import com.baasie.ExternalDependencies.IProvideAuditoriumLayouts;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class AuditoriumLayoutRepository implements IProvideAuditoriumLayouts {

    private final Map<String, AuditoriumDto> repository = new HashMap<>();

    public AuditoriumLayoutRepository() throws IOException {
        String jsonDirectoryForIntegrationTest = Paths.get(System.getProperty("user.dir")).getParent().getParent().getParent().getParent().toString() + "/Stubs/AuditoriumLayouts";
        String jsonDirectoryForUnittest = Paths.get(System.getProperty("user.dir")).getParent().getParent().getParent().toString() + "/Stubs/AuditoriumLayouts";
        String jsonDirectoryForBoot = Paths.get(System.getProperty("user.dir")).getParent().getParent().toString() + "/Stubs/AuditoriumLayouts";
        Path pathToFiles;
        if(Files.exists(Paths.get(jsonDirectoryForBoot))) {
            pathToFiles = Paths.get(jsonDirectoryForBoot);
        } else if(Files.exists(Paths.get(jsonDirectoryForIntegrationTest))) {
            pathToFiles = Paths.get(jsonDirectoryForIntegrationTest);
        } else {
            pathToFiles = Paths.get(jsonDirectoryForUnittest);
        }

        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathToFiles))
        {
            for (Path path : directoryStream)
            {
                if (path.toString().contains("_theater.json"))
                {
                    String fileName = path.getFileName().toString();
                    ObjectMapper mapper = new ObjectMapper().registerModule(new GuavaModule());
                    repository.put(fileName.split("-")[0], mapper.readValue(path.toFile(), AuditoriumDto.class));
                }
            }
        }
    }

    public AuditoriumDto GetAuditoriumLayoutFor(String showId) {
        if (repository.containsKey(showId)) {
            return repository.get(showId);
        }
        return new AuditoriumDto();
    }

    public AuditoriumDto getAuditoriumSeatingFor(String showId) {
        if (repository.containsKey(showId)) {
            return repository.get(showId);
        }

        return new AuditoriumDto();
    }
}
