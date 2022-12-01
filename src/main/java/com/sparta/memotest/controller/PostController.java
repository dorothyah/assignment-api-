package com.sparta.memotest.controller;

import com.sparta.memotest.dto.PostDeleteRequestDto;
import com.sparta.memotest.dto.PostDeleteResponseDto;
import com.sparta.memotest.dto.PostRequestDto;
import com.sparta.memotest.dto.PostResponseDto;
import com.sparta.memotest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody 이며, 메소드의 return(반환 결과값)을 문자열(JSON) 형태로 반환합니다.
                // view 가 필요없는 API 만 지원하는 클래스에 사용되며, json 이나 xml 과 같은 문자열의 return 이 주목적
@RequiredArgsConstructor // final 이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("/api/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/posts/{id}")
    public PostResponseDto getArticle(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PutMapping("/api/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public PostDeleteResponseDto deletePost(@PathVariable Long id, @RequestBody PostDeleteRequestDto requestDto){
        return new PostDeleteResponseDto(postService.deletePost(id, requestDto.getPassword()));
    }
}
