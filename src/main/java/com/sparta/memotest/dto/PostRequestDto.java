package com.sparta.memotest.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostRequestDto {
    private String username;
    private String title;
    private String contents;
    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;
}
