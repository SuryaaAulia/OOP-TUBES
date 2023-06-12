package com.QuiZZila.tubes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardController {
    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {
        return "dashboardView";
    }

    @GetMapping("/leaderboard")
    public String leaderboardPage(Model model) {
        return "leaderboardView";
    }

    @GetMapping("/quiz")
    public String quizPage(Model model) {
        return "quizView";
    }
}
