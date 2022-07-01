package com.example.pageable.repository;

import com.example.pageable.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByUserOrderByIdDesc(User user, Pageable pageable);
}
