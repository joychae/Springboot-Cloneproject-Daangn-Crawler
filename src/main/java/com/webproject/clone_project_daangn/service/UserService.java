package com.webproject.clone_project_daangn.service;



import com.webproject.clone_project_daangn.model.dto.SignupRequestDto;
import com.webproject.clone_project_daangn.model.entity.User;
import com.webproject.clone_project_daangn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();

        String password = passwordEncoder.encode(requestDto.getPassword());
        User user = new User(username, password);
        userRepository.save(user);
    }
}
