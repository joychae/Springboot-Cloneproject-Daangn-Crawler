package com.webproject.clone_project_daangn.controller;


import com.webproject.clone_project_daangn.model.dto.SignupRequestDto;
import com.webproject.clone_project_daangn.security.UserDetailsServiceImpl;
import com.webproject.clone_project_daangn.security.jwt.JwtTokenProvider;
import com.webproject.clone_project_daangn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;
    @Autowired
    public UserController(JwtTokenProvider jwtTokenProvider, UserService userService, UserDetailsServiceImpl userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping("/user/login")
    public String login(@RequestBody Map<String, String> user){
        System.out.println(user);
        UserDetails member = userDetailsService.loadUserByUsername(user.get("username"));
        return jwtTokenProvider.createToken(member.getUsername());
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/";
    }
}