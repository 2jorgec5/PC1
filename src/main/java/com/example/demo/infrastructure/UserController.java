package com.example.demo.infrastructure;
import com.example.demo.application.UserService;
import com.example.demo.dto.UserRegisterDTO;
import com.example.demo.dto.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO>register(
            @Valid @RequestBody UserRegisterDTO dto{
                UserResponseDTO responseDTO=userService.registerUser(dto);
                return ResponseEntity.of(responseDTO);
    }
}
