package com.eventify.eventify.controller;

import com.eventify.eventify.model.Event;
import com.eventify.eventify.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/api/events")
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/api/events/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/api/events")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

}