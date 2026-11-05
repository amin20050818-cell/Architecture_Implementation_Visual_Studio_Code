package com.example.quizservice;
import jakarta.persistence.*;
@Entity public class Question {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 public String text; public String optionA;public String optionB;public String optionC;public String optionD;public String correctAnswer;
 public Question(){} public Question(String t,String a,String bb,String c,String d,String correct){text=t;optionA=a;optionB=bb;optionC=c;optionD=d;correctAnswer=correct;}
}
