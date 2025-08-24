package com.ddg.QuizMS.dto;

import lombok.Data;

@Data
public class QuizQuestionDto {
    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
