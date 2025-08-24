package com.ddg.QuestionMS.repo;

import com.ddg.QuestionMS.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    @Query("SELECT id FROM Question WHERE category = ?1 ORDER BY RAND() LIMIT ?2")
    List<Integer> getRandomQuestions(String category, int numOfQuestions);
}
