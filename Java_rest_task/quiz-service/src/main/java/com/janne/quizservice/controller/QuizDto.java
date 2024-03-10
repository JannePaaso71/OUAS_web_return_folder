package com.janne.quizservice.controller;

import lombok.Data;

@Data
public class QuizDto {
    String category;
    String title;
    Integer numberOfQuestion;
}
