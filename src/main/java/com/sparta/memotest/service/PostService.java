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

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findByIdAndPassword(id, requestDto.getPassword()).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다.")
        );
        post.update(requestDto);
        postRepository.save(post);

        return new PostResponseDto(post);
    }

    @Transactional
    public boolean deletePost(Long id, String password) {
        if (postRepository.existsByIdAndPassword(id, password)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional (readOnly = true)
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new PostResponseDto(post);
    }

}
