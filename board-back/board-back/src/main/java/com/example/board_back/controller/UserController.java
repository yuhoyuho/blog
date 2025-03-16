package com.example.board_back.controller;

import com.example.board_back.dto.response.ResponseDto;
import com.example.board_back.dto.response.User.GetSignInUserResponseDto;
import com.example.board_back.dto.response.User.GetUserResponseDto;
import com.example.board_back.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{email}")
    public ResponseEntity<? super GetUserResponseDto> getUser(@PathVariable("email") String email) {
        ResponseEntity<? super GetUserResponseDto> response = userService.getUser(email);
        return response;
    }

    // @AuthenticationPrincipal = 인증한 사용자가 누군지 받아오는 애너테이션
    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(@AuthenticationPrincipal String email) {
        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }

}
