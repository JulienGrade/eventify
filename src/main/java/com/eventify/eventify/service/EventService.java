package com.eventify.eventify.service;

import com.eventify.eventify.model.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private Long nextId = 1L;

    public EventService() {

        events.add(
                new Event(
                        nextId++,
                        "Conférence Spring Boot",
                        "Introduction à Spring Boot",
                        LocalDateTime.now().plusDays(10)
                )
        );

    }

    public List<Event> getAllEvents() {
        return events;
    }

}