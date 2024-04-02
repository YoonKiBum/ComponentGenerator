package com.example.compgeneratorbe.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    //스프링 시큐리티에서는 권한 코드에 항상 **ROLE_이 앞에 있어야만 합니다**.
    ADMIN("ROLE_A", "관리자"),
    USER("ROLE_U", "일반 사용자");

    private final String key;
    private final String title;
}