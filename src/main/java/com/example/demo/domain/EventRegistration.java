package com.example.demo.domain;

import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.TimeZoneColumn;
import org.springframework.data.annotation.Reference;

import java.time.ZonedDateTime;

public class EventRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Reference(CampusEvent.class)
    private Long eventId;

    @Reference(TicketType.class)
    private Long ticketTypeId;

    @Reference(User.class)
    private Long attendeeId;

    @Column(nullable = false)
    private String name;

    @TimeZoneColumn
    private ZonedDateTime registeredAt;

    @RolesAllowed("CONFIRMED","CHECKED_IN","CANCELLED")
    private String status;
}
