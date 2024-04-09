package com.example.compgeneratorbe.controller;

import com.example.compgeneratorbe.model.UserPromptDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ChatGPTControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @DisplayName("userPrompt가 null이 아닌경우 정상 동작한다.")
    @Test
    void checkUserPromptSuccess() throws Exception {
        // given
        final String url = "/api/v1/chatGpt/prompt";
        final String userPrompt = "버튼 2개를 만들어줘";

        final UserPromptDto userPromptDto = UserPromptDto.builder()
                .userPrompt(userPrompt)
                .build();

        final String requestBody = objectMapper.writeValueAsString(userPromptDto);
        // when
        final ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.choices[0].message.content").exists());
    }

    @DisplayName("userPrompt가 null인 경우 에러가 발생한다.")
    @Test
    void checkUserPromptFail() throws Exception {
        // given
        final String url = "/api/v1/chatGpt/prompt";
        final String userPrompt = "";

        final String requestBody = objectMapper.writeValueAsString(userPrompt);

        // when
        final ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result
                .andExpect(status().isBadRequest());
    }
}