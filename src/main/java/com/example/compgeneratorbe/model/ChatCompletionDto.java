package com.example.compgeneratorbe.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatCompletionDto {

    private String model;
    private List<MessagesDto> messages;
    private Float temperature;

    @Builder
    public ChatCompletionDto(String model, List<MessagesDto> messages, Float temperature) {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
    }
}
