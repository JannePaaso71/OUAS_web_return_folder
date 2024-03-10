package com.Janne.Quiz.model;

//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionTitle;
    private String correctanswer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    //private String question;
    private String category;

    // public QuizQuestion() {
    // }

    // public QuizQuestion(String correctanswer, String option1, String option2, String option3, String option4,  String question, String category) {
    //     this.question = question;
    //     this.option1 = option1;
    //     this.option2 = option2;
    //     this.option3 = option3;
    //     this.option4 = option4;
    //     this.correctanswer = correctanswer;
    //     this.category = category;
    // }
}

