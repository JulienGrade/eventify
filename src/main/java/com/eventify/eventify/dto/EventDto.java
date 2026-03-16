package com.eventify.eventify.dto;

import java.time.LocalDateTime;

public class EventDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime eventDate;

    public EventDto() {
    }

    public EventDto(Long id, String title, String description, LocalDateTime eventDate) {
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