package com.aws.boot.application.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드도 칼럼으로 인식.
@EntityListeners(AuditingEntityListener.class) //Auditing : JPA에서 시간에 대해 자동으로 값을 넣는 기능.
public abstract class BaseTimeEntity {

    @CreatedDate //Entity가 생성되어 저장될떄 시간 자동저장.
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity값을 변경시 시간 자동저장.
    private LocalDateTime modifiedDate;
}