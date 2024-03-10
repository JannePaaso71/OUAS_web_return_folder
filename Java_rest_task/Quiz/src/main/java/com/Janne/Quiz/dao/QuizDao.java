package com.Janne.Quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Janne.Quiz.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Long>{

}
