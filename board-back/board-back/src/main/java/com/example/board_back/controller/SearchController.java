package com.example.board_back.controller;

import com.example.board_back.dto.response.Search.GetPopularListResponseDto;
import com.example.board_back.dto.response.Search.GetRelationListResponseDto;
import com.example.board_back.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/popular-list")
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {
        ResponseEntity<? super GetPopularListResponseDto> response = searchService.getPopularList();
        return response;
    }

    @GetMapping("/{searchWord}/relation-list")
    public ResponseEntity<? super GetRelationListResponseDto> getRelationList(@PathVariable("searchWord") String searchWord) {
        ResponseEntity<? super GetRelationListResponseDto> response = searchService.getRelationList(searchWord);
        return response;
    }
}
