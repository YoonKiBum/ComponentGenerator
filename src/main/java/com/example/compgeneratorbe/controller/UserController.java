package com.example.compgeneratorbe.controller;

import com.example.compgeneratorbe.domain.User;
import com.example.compgeneratorbe.dto.UserResponseDto;
import com.example.compgeneratorbe.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user")
    public ResponseEntity<UserResponseDto> getUserInfo(HttpServletRequest request) {
        String userEmail = (String) request.getAttribute("userEmail");
        User user = userService.findByEmail(userEmail);

        UserResponseDto userResponseDto = new UserResponseDto(user);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}
