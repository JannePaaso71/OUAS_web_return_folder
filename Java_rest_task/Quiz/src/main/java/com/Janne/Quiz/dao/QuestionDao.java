package com.Janne.Quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Janne.Quiz.model.QuizQuestion;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuizQuestion, Long>{
    
    List<QuizQuestion> findByCategory(String category);

    @Query(value = "SELECT * FROM quiz_question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numberOfQuestion", nativeQuery = true)
    List<QuizQuestion> findRandomQuestions(String category, int numberOfQuestion);
} 
