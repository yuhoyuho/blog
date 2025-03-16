package com.example.board_back.service;

import com.example.board_back.dto.response.User.GetSignInUserResponseDto;
import com.example.board_back.dto.response.User.GetUserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
}
