package com.aws.boot.application.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //모든 필드의 get메소드 생성
@RequiredArgsConstructor //final field가 포함된 생성자 생성.
public class HelloResponseDto {
      private final String name;
      private final int amount;

}
