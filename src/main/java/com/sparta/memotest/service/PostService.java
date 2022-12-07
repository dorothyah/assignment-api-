package com.sparta.memotest.service;

import com.sparta.memotest.dto.PostRequestDto;
import com.sparta.memotest.dto.PostResponseDto;
import com.sparta.memotest.entity.Post;
import com.sparta.memotest.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // Transaction 은 거래, 매매라는 뜻.
    // 데이터베이스를 다룰 때 트랜잭션을 적용하면 데이터 추가, 갱신, 삭제 등으로 이루어진 작업을 처리하던 중 오류가 발생했을 때
    // 모든 작업들을 원상태로 되돌릴 수 있다. 모든 작업들이 성공해야만 최종적으로 데이터베이스에 반영하도록 한다.
    // 스프링에서는 @Transactional 을 클래스나 메서드에 붙여줄 경우 해당 범위 내 메서드가 Transaction 되도록 보장해준다.
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true) // 스프링에서 제공하는 읽기 전용 모드로 설정
    public List<PostResponseDto> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

//    @Transactional
//    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
//        Post post = postRepository.findByIdAndPassword(id, requestDto.getPassword()).orElseThrow(
//                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다.")
//        );
//        post.update(requestDto);
//        postRepository.save(post);
//
//        return new PostResponseDto(post);
//    }

//    @Transactional
//    public boolean deletePost(Long id, String password) {
//        if (postRepository.existsByIdAndPassword(id, password)) {
//            postRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }

    @Transactional (readOnly = true)
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new PostResponseDto(post);
    }

}
