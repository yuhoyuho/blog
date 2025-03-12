package com.example.board_back.service.implement;

import com.example.board_back.dto.response.ResponseDto;
import com.example.board_back.dto.response.Search.GetPopularListResponseDto;
import com.example.board_back.repository.SearchLogRepository;
import com.example.board_back.repository.resultSet.GetPopularListResultSet;
import com.example.board_back.service.SearchService;
import lombok.NoArgsConstructor;
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
}
