package com.aws.boot.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화.
@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

}
