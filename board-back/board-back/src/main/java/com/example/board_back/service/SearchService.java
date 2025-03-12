package com.example.board_back.service;

import com.example.board_back.dto.response.Search.GetPopularListResponseDto;
import org.springframework.http.ResponseEntity;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
}
