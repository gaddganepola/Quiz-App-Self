package com.ddg.QuizMS.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CreateQuizDto {
    private String category;
    private int numOfQuestions;
}
