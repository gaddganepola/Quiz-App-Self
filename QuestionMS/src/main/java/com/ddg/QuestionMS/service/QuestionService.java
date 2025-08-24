package com.ddg.QuestionMS.service;

import com.ddg.QuestionMS.dto.CreateQuizDto;
import com.ddg.QuestionMS.dto.QuizAnswerDto;
import com.ddg.QuestionMS.dto.QuizQuestionDto;
import com.ddg.QuestionMS.model.Question;
import com.ddg.QuestionMS.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionRepo.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Question> updateQuestion(Question question, int id) {
        try {
            Optional<Question> questionData = questionRepo.findById(id);
            if (questionData.isPresent()) {
                Question _question = questionData.get();
                _question.setCategory(question.getCategory());
                _question.setQuestion(question.getQuestion());
                _question.setOption1(question.getOption1());
                _question.setOption2(question.getOption2());
                _question.setOption3(question.getOption3());
                _question.setOption4(question.getOption4());
                _question.setAnswer(question.getAnswer());
                return new ResponseEntity<>(questionRepo.save(_question), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try {
            Optional<Question> questionData = questionRepo.findById(id);
            if (questionData.isEmpty()) {
                return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
            }
            questionRepo.deleteById(id);
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Integer>> getRandomQuestions(CreateQuizDto createQuizDto) {
        try {
            List<Integer> questions = questionRepo.getRandomQuestions(createQuizDto.getCategory(), createQuizDto.getNumOfQuestions());
            if (questions.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else if (questions.size() != createQuizDto.getNumOfQuestions()) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(questions, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuizQuestionDto>> getQuizQuestions(List<Integer> questionIds) {
        try {
            List<Question> questions = questionRepo.findAllById(questionIds);
            List<QuizQuestionDto> quizQuestions = questions.stream().map(question -> {
                QuizQuestionDto quizQuestionDto = new QuizQuestionDto();
                quizQuestionDto.setId(question.getId());
                quizQuestionDto.setQuestion(question.getQuestion());
                quizQuestionDto.setOption1(question.getOption1());
                quizQuestionDto.setOption2(question.getOption2());
                quizQuestionDto.setOption3(question.getOption3());
                quizQuestionDto.setOption4(question.getOption4());
                return quizQuestionDto;
            }).toList();
            return new ResponseEntity<>(quizQuestions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> getResult(List<QuizAnswerDto> answers) {
        try {
            int score = 0;
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).getAnswer().equals(questionRepo.findById(answers.get(i).getId()).get().getAnswer())) {
                    score++;
                }
            }
            return new ResponseEntity<>(score, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
