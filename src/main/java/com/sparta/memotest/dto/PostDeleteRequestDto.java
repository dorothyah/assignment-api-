package com.sparta.memotest.dto;

import lombok.Getter;

@Getter
public class PostDeleteRequestDto {
    private String password; // Post 삭제 시 비밀번호 일치여부 확인하기 위함
}
