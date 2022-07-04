package com.example.pageable.service;

import com.example.pageable.dto.BoardResponseDto;
import com.example.pageable.entity.User;
import com.example.pageable.entity.Board;
import com.example.pageable.repository.BoardRepository;
import com.example.pageable.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

import static com.example.pageable.entity.User.createUser;

@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;


    @PostConstruct
    public void init() {
                User user = userRepository.save(
                        User.builder()
                        .userEmail("gogo@gogo@com")
                        .userName("gogo+1")
                        .userPhone("010-0000-0000")
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build());
        for (int i = 1; i < 5; i++) {
            boardRepository.save(
                    Board.builder()
                            .user(user)
                            .boardTitle("제목" + i)
                            .boardContents("내용" + i)
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build());
        }
    }

    public Page<BoardResponseDto> findAll(Pageable pageable) {
        return boardRepository.findByUserOrderByIdDesc(createUser(), pageable)
                .map(BoardResponseDto::from);
    }



}
