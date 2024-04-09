package com.example.compgeneratorbe.service;

import com.example.compgeneratorbe.model.UserPromptDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ChatGPTService {

    List<Map<String, Object>> modelList();

    Map<String, Object> prompt(UserPromptDto userPromptDto);

    Map<String, Object> isValidModel(String modelName);

}