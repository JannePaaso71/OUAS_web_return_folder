package com.janne.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.janne.quizservice.model.QuestionWrapper;
import com.janne.quizservice.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("/questios/generateRandomQuestion")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam int numberOfQuestions);
    
    @PostMapping("/questios/GetQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionsIds);

    @PostMapping("/questios/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
