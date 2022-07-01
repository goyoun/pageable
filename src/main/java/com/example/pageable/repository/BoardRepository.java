package com.example.pageable.repository;

import com.example.pageable.entity.Board;
import com.example.pageable.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Page<Board> findByBoardIdDesc(User user, Pageable pageable);
}
