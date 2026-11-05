package com.example.quizservice;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/quiz") public class QuizController {
 private final QuizService service;public QuizController(QuizService s){service=s;}
 @GetMapping("/start") public Quiz start(){return service.start();}
 @PostMapping("/check") public QuizResult check(@RequestBody List<Answer> answers){return service.check(answers);}
}
