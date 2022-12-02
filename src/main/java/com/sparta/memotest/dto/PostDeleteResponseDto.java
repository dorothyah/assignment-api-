package com.sparta.memotest.dto;

import lombok.Getter;

@Getter
public class PostDeleteResponseDto {
    private boolean success;

    public PostDeleteResponseDto(Boolean result){
        this.success = result;
    }
}

// DTO (Data Transfer Object)
// 계층간 데이터 교환을 위한 객체. 특별한 로직이 없는 순수한 데이터 객체여야 한다.