package com.aws.boot.application.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class HelloControllerTest {
    @Autowired // Bean 주입
    private MockMvc mvc;  //Web API 테스트시 사용. GET,POST 등 API테스트가능.

    @Test
    public void helloReturn() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) //MockMvc를 통해 HTTP GET요청
                .andExpect(status().isOk()) //mvc.perform의 결과 검증 200 404 500 등 상태검증
                .andExpect(content().string(hello)); //응답 본문 내용검증

    }

    @Test
    public void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }


}
