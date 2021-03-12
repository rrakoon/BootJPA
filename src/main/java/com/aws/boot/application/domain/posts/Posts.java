package com.aws.boot.application.domain.posts;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.aws.boot.application.domain.BaseTimeEntity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //기본생성자 자동추가
@Entity //테이블 링크 클래스
public class Posts extends BaseTimeEntity{
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk생성규칙
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private LocalDateTime createdDate;
    
    private LocalDateTime modifiedDate;

    @Builder //생성자 상단 선언시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
        public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
