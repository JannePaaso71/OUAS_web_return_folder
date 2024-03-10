package com.janne.quizservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.janne.quizservice.dao.QuizDao;
import com.janne.quizservice.feign.QuizInterface;
import com.janne.quizservice.model.Quiz;
import com.janne.quizservice.model.QuestionWrapper;
import com.janne.quizservice.model.Response;


import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numberOfQuestion, String title) {

        List<Integer> questionsIds = quizInterface.getQuestionForQuiz(category, numberOfQuestion).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionsIds);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(long id) {
        // Optional<Quiz> quiz = quizDao.findById(id);
        // List<QuizQuestion> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        // for (QuizQuestion question : questionsFromDB) {
        //     QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(),
        //             question.getOption2(), question.getOption3(), question.getOption4());
        //     questionsForUser.add(questionWrapper);
        //}

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(long id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        // List<QuizQuestion> questions = quiz.getQuestions();

        int score = 0;
        //int i = 0;
        // for(Response response : responses) {           
        //     if(response.getResponse().equals(questions.get(i).getCorrectanswer())) {
        //         score++;
        //         i++;
        //     }                       
        // }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
