package com.aws.boot.application.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> { //<Entity class, PK type>
    
}