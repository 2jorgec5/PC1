package com.example.demo.application;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.dto.UserRegisterDTO;
import com.example.demo.dto.UserResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public UserResponseDTO registerUser(UserRegisterDTO dto){
        User user=new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());

        user.setPassword(PasswordEncoder.encode(dto.getPassword()));

        User savedUser=userRepository.save(user);
        return new UserResponseDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }
}
