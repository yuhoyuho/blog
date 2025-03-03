package com.example.board_back.service;

import com.example.board_back.dto.request.board.PostBoardRequestDto;
import com.example.board_back.dto.response.board.PostBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {

    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
}
