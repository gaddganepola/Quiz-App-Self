package com.ddg.QuizMS.service;

import com.ddg.QuizMS.dto.QuizAnswerDto;
import com.ddg.QuizMS.dto.QuizQuestionDto;
import com.ddg.QuizMS.feign.Feign;
import com.ddg.QuizMS.dto.CreateQuizDto;
import com.ddg.QuizMS.dto.RequestDto;
import com.ddg.QuizMS.model.Quiz;
import com.ddg.QuizMS.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private Feign feign;

    @Autowired
    private CreateQuizDto createQuizDto;

    public ResponseEntity<Quiz> addQuiz(RequestDto requestDto) {
        try {
            List<Integer> questionIds = new ArrayList<>();
            createQuizDto.setCategory(requestDto.getCategory());
            createQuizDto.setNumOfQuestions(requestDto.getNumOfQuestions());
            questionIds = feign.getRandomQuestions(createQuizDto).getBody();
            Quiz quiz = new Quiz();
            quiz.setTitle(requestDto.getTitle());
            quiz.setQuestionIds(questionIds);
            return new ResponseEntity<>(quizRepo.save(quiz), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuizQuestionDto>> getQuiz(int id) {
        try {
            Optional<Quiz> quiz = quizRepo.findById(id);
            if (quiz.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return feign.getQuizQuestions(quiz.get().getQuestionIds());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> getResult(List<QuizAnswerDto> answers, int id) {
        try {
            List<Integer> questionIds = quizRepo.findById(id).get().getQuestionIds();
            for (int i = 0; i < answers.size(); i++) {
                if (!questionIds.contains(answers.get(i).getId())) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
            return feign.getResult(answers);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
