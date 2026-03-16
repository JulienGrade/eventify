package com.eventify.eventify.service;

import com.eventify.eventify.dto.EventDto;
import com.eventify.eventify.model.Event;
import com.eventify.eventify.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDto> getAllEvents() {

        List<Event> events = eventRepository.findAll();

        return events.stream()
                .map(this::mapToDto)
                .toList();
    }

    public EventDto getEventById(Long id) {

        Event event = eventRepository.findById(id).orElse(null);

        if (event == null) {
            return null;
        }

        return mapToDto(event);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {

        Event event = eventRepository.findById(id).orElse(null);

        if (event == null) {
            return null;
        }

        event.setTitle(updatedEvent.getTitle());
        event.setDescription(updatedEvent.getDescription());
        event.setEventDate(updatedEvent.getEventDate());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    private EventDto mapToDto(Event event) {
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getEventDate()
        );
    }
}