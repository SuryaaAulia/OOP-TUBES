package com.QuiZZila.tubes.Controller;

import com.QuiZZila.tubes.Model.Quiz;
import com.QuiZZila.tubes.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class addQuizController {

    @Autowired
    private QuizRepository quizRepository;

    @PostMapping("/addQuiz")
    public String addQuiz(Quiz quiz) {
        quizRepository.save(quiz);
        return "redirect:/";
    }
}
