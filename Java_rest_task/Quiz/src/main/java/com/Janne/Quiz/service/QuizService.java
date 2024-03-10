package com.Janne.Quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Janne.Quiz.model.QuestionWrapper;
import com.Janne.Quiz.dao.QuestionDao;
import com.Janne.Quiz.dao.QuizDao;
import com.Janne.Quiz.model.Quiz;
import com.Janne.Quiz.model.QuizQuestion;
import com.Janne.Quiz.model.Response;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numberOfQuestion, String title) {

        List<QuizQuestion> questions = questionDao.findRandomQuestions(category, numberOfQuestion);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(long id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<QuizQuestion> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (QuizQuestion question : questionsFromDB) {
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(),
                    question.getOption2(), question.getOption3(), question.getOption4());
            questionsForUser.add(questionWrapper);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(long id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<QuizQuestion> questions = quiz.getQuestions();

        int score = 0, i = 0;
        for(Response response : responses) {           
            if(response.getResponse().equals(questions.get(i).getCorrectanswer())) {
                score++;
                i++;
            }                       
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
