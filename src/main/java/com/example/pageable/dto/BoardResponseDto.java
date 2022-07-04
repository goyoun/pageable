package com.example.pageable.dto;

import com.example.pageable.entity.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class BoardResponseDto {

    private final Long id;
    private final String userName;
    private final String boardTitle;
    private final String boardContent;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static BoardResponseDto from(Board board) {
        return BoardResponseDto
                .builder()
                .id(board.getId())
                .userName(board.getUser().getUserName())
                .boardTitle(board.getBoardTitle())
                .boardContent(board.getBoardContents())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

}
