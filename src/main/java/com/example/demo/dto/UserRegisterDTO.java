package com.example.demo.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UserRegisterDTO {
    @NotBlank
    private String username;

    @NotBlank
    @Email (message = "El email debe tener formato valido")
    private String email;

    @NotBlank
    @Pattern(regexp = ".*[0-9].*",message = "Al menos un numero")
    private String password;


}
