package com.example.pageable.repository;

import com.example.pageable.entity.Board;
import com.example.pageable.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findByUserOrderByIdDesc(User user, Pageable pageable);
}
