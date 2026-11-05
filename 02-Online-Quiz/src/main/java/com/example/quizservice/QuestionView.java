package com.example.quizservice;
public record QuestionView(Long id,String text,String optionA,String optionB,String optionC,String optionD){public static QuestionView from(Question q){return new QuestionView(q.id,q.text,q.optionA,q.optionB,q.optionC,q.optionD);}}
