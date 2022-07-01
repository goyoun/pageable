package com.example.pageable.controller;

import com.example.pageable.entity.Board;
import com.example.pageable.entity.User;
import com.example.pageable.repository.BoardRepository;
import com.example.pageable.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;



    @GetMapping("/")
    public Page<User> userPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
