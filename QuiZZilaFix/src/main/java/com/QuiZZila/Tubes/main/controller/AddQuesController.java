package com.QuiZZila.Tubes.main.controller;

import com.QuiZZila.Tubes.main.model.Hasil;
import com.QuiZZila.Tubes.main.model.Question;
import com.QuiZZila.Tubes.main.model.Users;
import com.QuiZZila.Tubes.main.repository.QuestionRepository;
import com.QuiZZila.Tubes.main.service.QuizService;
import com.QuiZZila.Tubes.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
@Controller
public class AddQuesController {
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/addQuestion")
    public String addQuestion(Model model, HttpServletRequest request) {
        Users users = (Users) request.getSession().getAttribute("users");
        if (users == null){
            return "redirect:/login";
        }
        model.addAttribute("title", "");
        model.addAttribute("optionA", "");
        model.addAttribute("optionB", "");
        model.addAttribute("optionC", "");
        model.addAttribute("ans", 0);

        return "addQuestion";
    }

    @PostMapping("/addQuestion")
    public String addQuestion(
            @RequestParam("title") String title,
            @RequestParam("optionA") String optionA,
            @RequestParam("optionB") String optionB,
            @RequestParam("optionC") String optionC,
            @RequestParam("ans") int ans) {
        Question question = new Question(title, optionA, optionB, optionC, ans, -1);
        questionRepository.save(question);
        return "/selectedQuestion";
    }
}
