package com.example.demo.domain;

import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.TimeZoneColumn;
import org.springframework.data.annotation.Reference;

import java.time.ZonedDateTime;

public class CampusEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Reference(User.class)
    private Long organizedId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Pattern(regexp = ".*>500.*",message = "Maximo 500 caracteres")
    private String description;

    @RolesAllowed("ACADEMIC","CULTURAL","SPORTS","TECHNOLOGY")
    private String caterogy;

    @TimeZoneColumn
    private ZonedDateTime eventDate;

    @Column(nullable = false)
    private String location;

    @RolesAllowed("DRAFT","PUBLISHED","CANCELLED","FINISHED")
    private String status;
}
