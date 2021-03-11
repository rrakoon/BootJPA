package com.aws.boot.application.domain.posts;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootApplication
@ExtendWith(SpringExtension.class)
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach //Junit4 @After와 동일. 해당 어노테이션이 달린 메서드가 각 테스트 메서드 이후 실행
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void notice_call() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //postsRepository.save - posts테이블에 insert/update실행. id가 있으면 update, 없으면 insert쿼리 실행
                .title(title)
                .content(content)
                .author("rrakoon@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //모든데이터 조회메서드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

}
