package com.ddg.QuizMS.controller;

import com.ddg.QuizMS.dto.QuizAnswerDto;
import com.ddg.QuizMS.dto.QuizQuestionDto;
import com.ddg.QuizMS.dto.RequestDto;
import com.ddg.QuizMS.model.Quiz;
import com.ddg.QuizMS.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;


    @PostMapping("/add")
    public ResponseEntity<Quiz> addQuiz(@RequestBody RequestDto requestDto) {
        return quizService.addQuiz(requestDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuizQuestionDto>> getQuiz(@PathVariable int id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> getResult(@RequestBody List<QuizAnswerDto> answers, @PathVariable int id) {
        return quizService.getResult(answers, id);
    }
}
