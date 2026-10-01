package com.example.demo.domain;

import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Reference;


public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Reference(CampusEvent.class)
    private Long eventId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Positive(message = "Debe ser <=1")
    private Integer capacity;

    @Column(columnDefinition = "0")
    private Integer registeredCount;

    @RolesAllowed("AVAILABLE","FULL","INACTIVE")
    private String status;
}
