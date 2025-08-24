package com.ddg.QuizMS.dto;

import lombok.Data;

@Data
public class RequestDto {
    private String title;
    private String category;
    private int numOfQuestions;
}
