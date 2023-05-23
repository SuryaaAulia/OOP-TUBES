package com.QuiZZila.tubes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardController {
    @GetMapping("/dashboard")
    public String dashboardpage(Model dashboard){
        return "dashboardView.html";
    }
    @GetMapping("/leaderboard")
    public String leaderboardpage(Model leaderboard){
        return "leaderboardView.html";
    }
    @GetMapping("/addQuiz")
    public String createquizpage(Model createQuiz){
        return "addQuizView.html";
    }
    @GetMapping("/quiz")
    public String quizpage(Model quiz){
        return "quizView";
    }
}
