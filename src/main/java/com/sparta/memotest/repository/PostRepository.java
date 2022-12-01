package com.sparta.memotest.repository;

import com.sparta.memotest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> { // JpaRepository 의 기능을 상속받는다.
    List<Post> findAllByOrderByCreatedAtDesc(); //
    Optional<Post> findByIdAndPassword(Long id, String password);
    Boolean existsByIdAndPassword(Long id, String password);
}

// Spring Data JPA 는 간단한 CRUD 기능을 공통으로 처리하는 interface 를 제공하는데
// 이를 사용하여 자주 사용되는 CRUD 를 굳이 JPQL 로 작성하지 않아도 된다.

// entity 에 의해 생성된 DB에 접근하는 method 를 사용하기 위한 인터페이스이다.
// service 와 DB 를 연결하는 고리의 역할을 한다.