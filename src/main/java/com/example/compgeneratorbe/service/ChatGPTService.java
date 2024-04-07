package com.example.compgeneratorbe.service;

import com.example.compgeneratorbe.model.ChatCompletionDto;
import com.example.compgeneratorbe.model.CompletionRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ChatGPTService {

    List<Map<String, Object>> modelList();

    Map<String, Object> prompt(String userPrompt);

    Map<String, Object> isValidModel(String modelName);

}