package com.example.compgeneratorbe.controller;

import com.example.compgeneratorbe.common.exception.BusinessException;
import com.example.compgeneratorbe.model.UserPromptDto;
import com.example.compgeneratorbe.service.ChatGPTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/chatGpt")
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    /**
     * [API] ChatGPT 모델 리스트를 조회합니다.
     */
    @GetMapping("/modelList")
    public ResponseEntity<List<Map<String, Object>>> selectModelList() {
        List<Map<String, Object>> result = chatGPTService.modelList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * [API] ChatGPT 유효한 모델인지 조회합니다.
     *
     * @param modelName
     * @return
     */
    @GetMapping("/model")
    public ResponseEntity<Map<String, Object>> isValidModel(@RequestParam(name = "modelName") String modelName) {
        Map<String, Object> result = chatGPTService.isValidModel(modelName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * [API] ChatGPT 모델 리스트를 조회합니다.
     */
    @PostMapping("/prompt")
    public ResponseEntity<Map<String, Object>> selectPrompt(@RequestBody UserPromptDto userPromptDto) {
        try {
            // 서비스 메소드 호출
            Map<String, Object> result = chatGPTService.prompt(userPromptDto);
            // 성공적으로 처리된 경우 ResponseEntity로 반환
            return ResponseEntity.ok(result);
        } catch (BusinessException e) {
            // BusinessException 발생 시 예외 처리
            return ResponseEntity.status(e.getHttpStatus())
                    .body(Map.of("status", e.getHttpStatus(), "error", e.getMessage()));
        }
    }
}
