package com.example.board_back.service.implement;

import com.example.board_back.dto.response.ResponseDto;
import com.example.board_back.dto.response.Search.GetPopularListResponseDto;
import com.example.board_back.dto.response.Search.GetRelationListResponseDto;
import com.example.board_back.repository.SearchLogRepository;
import com.example.board_back.repository.resultSet.GetPopularListResultSet;
import com.example.board_back.repository.resultSet.GetRelationListResultSet;
import com.example.board_back.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImplement implements SearchService {

    private final SearchLogRepository searchLogRepository;

    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {

        List<GetPopularListResultSet> resultSets = new ArrayList<>();

        try {

            resultSets = searchLogRepository.getPopularList();

        }catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetPopularListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord) {

        List<GetRelationListResultSet> resultSets = new ArrayList<>();

        try {

            resultSets = searchLogRepository.getRelationList(searchWord);

        }catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetRelationListResponseDto.success(resultSets);
    }
}
