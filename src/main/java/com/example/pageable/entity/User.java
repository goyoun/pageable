package com.example.pageable.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String userEmail;

    private String userPhone;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static User createUser() {
        return User.builder()
                .id(1L)
                .userName("go")
                .userEmail("gogo@gogo.com")
                .userPhone("010-0000-0000")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
