package com.ddg.QuizMS.feign;

import com.ddg.QuizMS.dto.CreateQuizDto;
import com.ddg.QuizMS.dto.QuizAnswerDto;
import com.ddg.QuizMS.dto.QuizQuestionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("QuestionMS")
public interface Feign {

    @PostMapping("/question/generate-quiz-questions")
    public ResponseEntity<List<Integer>> getRandomQuestions(@RequestBody CreateQuizDto createQuizDto);

    @PostMapping("/question/quiz/questions")
    public ResponseEntity<List<QuizQuestionDto>> getQuizQuestions(@RequestBody List<Integer> questionIds);

    @PostMapping("/question/get-result")
    public ResponseEntity<Integer> getResult(@RequestBody List<QuizAnswerDto> answers);

}
