package com.aws.boot.application.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloResponseDtoTest {
    @Test
    public void lombockTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()) //assertj 테스트 검증 라이브러리 검증 메소드
                .isEqualTo(name); //동등비교 메소드 assertThat에 있는 값과 같을경우만 성공.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
