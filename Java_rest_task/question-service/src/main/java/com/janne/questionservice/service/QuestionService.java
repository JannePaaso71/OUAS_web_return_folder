package com.janne.questionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.janne.questionservice.dao.QuestionDao;
import com.janne.questionservice.model.QuestionWrapper;
import com.janne.questionservice.model.QuizQuestion;
import com.janne.questionservice.model.Response;

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

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, int numberOfQuestions) {
        List<Integer> questions = questionDao.findRandomQuestions(category, numberOfQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        for (Integer id : questionsIds) {
            quizQuestions.add(questionDao.findById(id).get());
            };

        for (QuizQuestion question : quizQuestions) {
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int score = 0;
        for(Response response : responses) {      
            QuizQuestion quizQuestion = questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(quizQuestion.getCorrectanswer())) {
                score++;
            }                       
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

}
