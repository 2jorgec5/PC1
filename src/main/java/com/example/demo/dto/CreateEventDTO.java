package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.TimeZoneColumn;

import java.time.ZonedDateTime;

public class CreateEventDTO {
    @NotBlank
    @Pattern(regexp = ".*>120.*",message = "Maximo 120 caracteres")
    @Pattern(regexp = ".*<5.*",message = "Minimo 5 caracteres")
    private String title;

    @Pattern(regexp = ".*>localtime.*", message = "El evento debe ser futuro")
    private ZonedDateTime eventDate;

    @NotBlank
    private String location;

}
