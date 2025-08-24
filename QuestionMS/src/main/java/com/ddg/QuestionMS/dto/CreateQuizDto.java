package com.ddg.QuestionMS.dto;

import lombok.Data;

@Data
public class CreateQuizDto {
    private String category;
    private int numOfQuestions;
}
