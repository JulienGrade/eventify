package com.eventify.eventify.model;

import java.time.LocalDateTime;

public class Event {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime eventDate;

    public Event(Long id, String title, String description, LocalDateTime eventDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

}