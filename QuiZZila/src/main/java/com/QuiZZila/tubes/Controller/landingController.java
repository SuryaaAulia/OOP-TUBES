package com.QuiZZila.tubes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class landingController {

    @GetMapping("/join")
    public String landingpage(Model main){

        return "mainView";
    }
    @GetMapping("/login")
    public String loginpage(Model login){
        return "loginView";
    }
    @GetMapping("/quizCode")
    public String quizpage(Model quiz){
        return "quizView";
    }
}