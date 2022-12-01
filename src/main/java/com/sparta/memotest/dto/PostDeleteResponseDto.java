package com.sparta.memotest.dto;

import lombok.Getter;

@Getter
public class PostDeleteResponseDto {
    private boolean success;

    public PostDeleteResponseDto(Boolean result){
        this.success = result;
    }
}
