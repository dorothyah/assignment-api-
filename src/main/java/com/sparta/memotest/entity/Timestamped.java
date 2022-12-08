package com.sparta.memotest.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 해당 어노테이션이 적용된 클래스는 실제 테이블과 매핑되지 않는다. 대신 이 클래스를 상속받은 entity 와 매핑되는 테이블에 정보를 제공한다.
                // 테이블과 관련이 없고 단순히 공통으로 사용하는 매핑 정보만 제공하기 위해 사용한다.
@EntityListeners(AuditingEntityListener.class)
// Entity 의 변화를 감지하여 Entity 와 매핑된 테이블의 데이터를 조작한다.
// AuditingEntityListener 클래스는 entity 의 영속, 수정 이벤트를 감지하는 역할을 한다.
public class Timestamped {

    @CreatedDate
    private LocalDateTime createdAt; // 생성된 시간 표시

    @LastModifiedDate
    private LocalDateTime modifiedAt; // 수정된 시간 표시 
}
