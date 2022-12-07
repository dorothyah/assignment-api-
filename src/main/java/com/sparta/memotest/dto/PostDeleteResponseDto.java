package com.sparta.memotest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDeleteResponseDto {

    private String msg;
    private int statusCode;

    public PostDeleteResponseDto(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}

// DTO (Data Transfer Object)
// 계층간 데이터 교환을 위한 객체. 특별한 로직이 없는 순수한 데이터 객체여야 한다.