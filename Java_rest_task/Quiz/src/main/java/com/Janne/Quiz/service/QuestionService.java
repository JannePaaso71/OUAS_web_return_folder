package com.Janne.Quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Janne.Quiz.dao.QuestionDao;
//import com.Janne.Quiz.repository.QuestionRepository;
import com.Janne.Quiz.model.QuizQuestion;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<QuizQuestion>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuizQuestion>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(QuizQuestion question) {
        questionDao.save(question);
        return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    }

    // public QuestionService(QuestionRepository questionRepository) {
    //     this.questionRepository = questionRepository;
    // }

    // public List<QuizQuestion> getAllQuestions() {
    //     
    //     throw new UnsupportedOperationException("Unimplemented method 'getAllQuestions'");
    // }

}
