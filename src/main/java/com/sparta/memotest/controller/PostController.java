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
@RequestMapping("/api") // 공통적으로 사용하는 URL 은 이런식으로 사용할 수 있다.
// 특정 URL 로 요청을 보내면 Controller 에서 어떠한 방식으로 처리할지 정의를 하는데,
// 이때 들어온 요청을 특정 메서드와 매핑하기 위해 사용하는 것이 @RequestMapping 이다.
// 원래는 GetMapping, PostMapping 등이
// @RequestMapping(value="경로", method=RequestMethod.GET)
// 이런식으로 사용되었으나 스프링 4.3 이후로 아래의 쓰임과 같이 변경되었다.
public class PostController {

    private final PostService postService;

    @GetMapping("/posts") // GET 요청을 받기 위해 사용
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }
    // List 형식으로 반환

    @PostMapping("/posts") // POST 요청을 받기 위해 사용
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }
    // @RequestBody, Json 기반의 http Body 를 자바 객체로 변환 / 클라이언트 > 서버 요청 : @RequestBody
    // @ResponseBody, 자바 객체를 Json 기반의 http Body 로 변환 / 서버 > 클라이언트 응답 : @ResponseBody

    @GetMapping("/posts/{id}")
    public PostResponseDto getArticle(@PathVariable Long id){
        return postService.getPost(id);
    }
    // @PathVariable, http 의 요청에 대해 매칭되는 request parameter 값이 자동으로 매칭된다.

//    @PutMapping("/posts/{id}") // PUT 요청을 받기 위해 사용
//    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
//        return postService.updatePost(id, requestDto);
//    }

//    @DeleteMapping("/posts/{id}") // DELETE 요청을 받기 위해 사용
//    public PostDeleteResponseDto deletePost(@PathVariable Long id, @RequestBody PostDeleteRequestDto requestDto){
//        return new PostDeleteResponseDto(postService.deletePost(id, requestDto.getPassword()));
//    }
}
