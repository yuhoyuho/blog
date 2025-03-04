package com.example.board_back.service;

import com.example.board_back.dto.request.board.PostBoardRequestDto;
import com.example.board_back.dto.response.board.GetBoardResponseDto;
import com.example.board_back.dto.response.board.PostBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {

    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
}
