package com.ddg.QuestionMS.controller;

import com.ddg.QuestionMS.dto.CreateQuizDto;
import com.ddg.QuestionMS.dto.QuizAnswerDto;
import com.ddg.QuestionMS.dto.QuizQuestionDto;
import com.ddg.QuestionMS.model.Question;
import com.ddg.QuestionMS.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question, @PathVariable int id) {
        return questionService.updateQuestion(question, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }

    @PostMapping("/generate-quiz-questions")
    public ResponseEntity<List<Integer>> getRandomQuestions(@RequestBody CreateQuizDto createQuizDto) {
        return questionService.getRandomQuestions(createQuizDto);
    }

    @PostMapping("/quiz/questions")
    public ResponseEntity<List<QuizQuestionDto>> getQuizQuestions(@RequestBody List<Integer> questionIds) {
        return questionService.getQuizQuestions(questionIds);
    }

    @PostMapping("/get-result")
    public ResponseEntity<Integer> getResult(@RequestBody List<QuizAnswerDto> answers) {
        return questionService.getResult(answers);
    }
}
