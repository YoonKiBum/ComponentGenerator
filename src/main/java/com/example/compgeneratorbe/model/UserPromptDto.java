package com.example.compgeneratorbe.model;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserPromptDto {

    private String userPrompt;

    @Builder
    public UserPromptDto(String userPrompt) {
        this.userPrompt = userPrompt;
    }
}
