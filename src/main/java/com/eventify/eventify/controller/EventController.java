package com.eventify.eventify.controller;

import com.eventify.eventify.dto.EventDto;
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
    public List<EventDto> getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/api/events/{id}")
    public EventDto getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/api/events")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/api/events/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("/api/events/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

}