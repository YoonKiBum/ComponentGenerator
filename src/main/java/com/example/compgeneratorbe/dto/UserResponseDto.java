package com.example.compgeneratorbe.dto;

import com.example.compgeneratorbe.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponseDto {

    private String email;

    private String nickName;

    public UserResponseDto(User user) {
        this.email = user.getEmail();
        this.nickName = user.getNickname();
    }
}
