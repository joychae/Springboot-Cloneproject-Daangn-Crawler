package com.webproject.clone_project_daangn.service;


import com.azul.crs.shared.models.UserRole;
import com.webproject.clone_project_daangn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        User user = new User(username, password);
        userRepository.save(user);
    }
}
