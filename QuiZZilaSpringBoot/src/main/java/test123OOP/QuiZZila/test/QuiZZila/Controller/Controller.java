package test123OOP.QuiZZila.test.QuiZZila.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String landingpage(Model main){

        return "mainView.html";
    }
    @GetMapping("/login")
    public String loginpage(Model login){
        return "loginView.html";
    }
    @GetMapping("/dashboard")
    public String dashboardpage(Model dashboard){
        return "dashboardView.html";
    }
    @GetMapping("/quiz")
    public String quizpage(Model quiz){
        return "quizView.html";
    }
    @GetMapping("/leaderboard")
    public String leaderboardpage(Model leaderboard){
        return "leaderboardView.html";
    }
    @GetMapping("/addQuiz")
    public String createquizpage(Model createQuiz){
        return "addQuizView.html";
    }
    @GetMapping("/end")
    public String endpage(Model end){
        return "endView.html";
    }
}
