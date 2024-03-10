package com.janne.questionservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.janne.questionservice.model.QuizQuestion;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao extends JpaRepository<QuizQuestion, Long>{
    
    List<QuizQuestion> findByCategory(String category);

    @Query(value = "SELECT q.id FROM quiz_question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numberOfQuestion", nativeQuery = true)
    List<Integer> findRandomQuestions(String category, int numberOfQuestion);

    Optional<QuizQuestion> findById(Integer id);
} 
