package com.janne.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.janne.quizservice.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Long>{

}
