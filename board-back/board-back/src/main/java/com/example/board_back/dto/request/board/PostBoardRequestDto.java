package com.example.board_back.dto.request.board;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostBoardRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private List<String> boardImageList;
}
