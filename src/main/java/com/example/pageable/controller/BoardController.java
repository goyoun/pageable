package com.example.pageable.controller;

import com.example.pageable.dto.BoardResponseDto;
import com.example.pageable.service.BoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/")
    public List<BoardResponseDto> find(@PageableDefault(size = 7) Pageable pageable) {
        return boardService.findAll(pageable).getContent();
    }
}
