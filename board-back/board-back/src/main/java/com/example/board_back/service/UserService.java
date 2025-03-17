package com.example.board_back.service;

import com.example.board_back.dto.request.user.PatchNicknameRequestDto;
import com.example.board_back.dto.request.user.PatchProfileImageRequestDto;
import com.example.board_back.dto.response.User.GetSignInUserResponseDto;
import com.example.board_back.dto.response.User.GetUserResponseDto;
import com.example.board_back.dto.response.User.PatchNicknameResponseDto;
import com.example.board_back.dto.response.User.PatchProfileImageResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);
    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email);
}
