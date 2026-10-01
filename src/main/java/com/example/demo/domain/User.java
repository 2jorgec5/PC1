package com.example.demo.domain;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @RolesAllowed("ROLE_ATTENDEE","ROLE_ORGANIZER","ROLE_ADMIN")
    private String role;
}
