package com.eventify.eventify.seed;

import com.eventify.eventify.model.Event;
import com.eventify.eventify.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Configuration
@Profile("dev")
public class DevEventSeeder {

    @Bean
    CommandLineRunner seedEvents(EventRepository eventRepository) {
        return args -> {

            if (eventRepository.count() == 0) {

                Event e1 = new Event(
                        "Conférence Spring Boot",
                        "Introduction à Spring Boot",
                        LocalDateTime.now().plusDays(10)
                );

                Event e2 = new Event(
                        "Workshop Java",
                        "Atelier pratique Java",
                        LocalDateTime.now().plusDays(20)
                );

                Event e3 = new Event(
                        "Hackathon",
                        "48h de code intensif",
                        LocalDateTime.now().plusDays(30)
                );

                eventRepository.save(e1);
                eventRepository.save(e2);
                eventRepository.save(e3);
            }
        };
    }
}