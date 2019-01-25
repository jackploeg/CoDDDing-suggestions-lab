package com.baasie.AuditoriumLayoutApi;

import com.baasie.ExternalDependencies.IProvideAuditoriumLayouts;
import com.baasie.ExternalDependencies.auditoriumlayoutrepository.AuditoriumLayoutRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan("com.baasie.ExternalDependencies")
public class config {

    @Bean
    public IProvideAuditoriumLayouts iProvideAuditoriumLayouts() throws IOException {
        return new AuditoriumLayoutRepository();
    }
}
