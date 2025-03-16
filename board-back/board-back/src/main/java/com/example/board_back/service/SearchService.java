package com.example.board_back.service;

import com.example.board_back.dto.response.Search.GetPopularListResponseDto;
import com.example.board_back.dto.response.Search.GetRelationListResponseDto;
import org.springframework.http.ResponseEntity;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
    ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord);
}
