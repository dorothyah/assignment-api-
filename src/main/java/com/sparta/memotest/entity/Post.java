package com.sparta.memotest.entity;

import com.sparta.memotest.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// @Table (name = "이름") 로 매핑할 테이블 이름을 지정할 수 있고 생략 시 매핑한 entity 이름을 테이블 이름으로 사용
@Getter
@Entity // 실제 DB의 테이블과 매칭되는 클래스. DB 테이블에 존재하는 Column 들을 필드로 가진다.
        // Entity 를 그대로 반환할 경우 원하는 정보만을 표시하기 어렵기 때문에 DTO 를 따로 만들어 사용한다.
@NoArgsConstructor
public class Post extends Timestamped { // Timestamped 의 생성 시간, 수정 시간에 대한 부분을 상속받는다.

    @Id // 해당 column 이 식별키(PK, Primary Key)라는 것을 의미
    @GeneratedValue(strategy = GenerationType.AUTO) // PK의 생성 방법을 지정
    private Long id;                                // 생성 전략(strategy)과 생성기(generator)를 설정할 수 있다.
                                                    // AUTO 는 특정 DB에 맞게 자동으로 생성되는 방식
    @Column(nullable = false) // 필드를 테이블 column 에 매핑하는데 사용. 빈 값이 없도록 nullable = false 를 설정
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    // 최대한 외부에서 Entity 클래스의 getter method 를 사용하지 않도록 해당 클래스 안에서 필요한 logic method 를 구현한다.
    public Post(PostRequestDto requestDto, User user) {
        this.username = user.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.user = user;
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
    }
}