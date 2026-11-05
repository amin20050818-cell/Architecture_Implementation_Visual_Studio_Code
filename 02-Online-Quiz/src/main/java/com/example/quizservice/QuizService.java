package com.example.quizservice;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
@Service public class QuizService {
 private final QuestionRepository repo;public QuizService(QuestionRepository repo){this.repo=repo;}
 public Quiz start(){return new Quiz(repo.findAll().stream().map(QuestionView::from).toList());}
 public QuizResult check(List<Answer> answers){int score=0;Set<Long> seen=new HashSet<>();for(Answer a:answers){if(a.questionId()==null||!seen.add(a.questionId()))continue;Optional<Question> q=repo.findById(a.questionId());if(q.isPresent()&&q.get().correctAnswer.equalsIgnoreCase(Objects.toString(a.selectedOption(),"")))score++;}return new QuizResult(score,repo.findAll().size());}
 @Bean CommandLineRunner seed(QuestionRepository r){return args->{if(r.count()==0){r.save(new Question("What is REST?","Web API style","Database","OS","Compiler","A"));r.save(new Question("What does HTTP 200 mean?","Error","OK","Deleted","Unauthorized","B"));}};}
}
