package com.example.compgeneratorbe.model;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class MessagesDto {

    private String role;
    private String content;

    @Builder
    public MessagesDto(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
