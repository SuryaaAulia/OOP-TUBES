package com.QuiZZila.Tubes.main.controller;

import com.QuiZZila.Tubes.main.model.*;
import com.QuiZZila.Tubes.main.repository.QuestionRepository;
import com.QuiZZila.Tubes.main.service.QuizService;
import com.QuiZZila.Tubes.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class QuizController {

    @Autowired
    Hasil hasil;
    @Autowired
    QuestionRepository questionRepository;
    Boolean submitted = false;

    @PostMapping("/quiz")
    public String quiz(@RequestParam(value = "numQuestions", required = false) Integer numQuestions,
                       @RequestParam("username") String username,
                       Model model, RedirectAttributes redirectAttributes,
                       HttpServletRequest request) {
        if (numQuestions != null && numQuestions > 0) {
            Users users = (Users) request.getSession().getAttribute("users");
            if (users == null) {
                return "redirect:/login";
            }
        }

        if (username.equals("")) {
            redirectAttributes.addFlashAttribute("warning", "Tolong masukkan nama!");
            return "redirect:/";
        }

        submitted = false;
        hasil.setUsername(username);

        List<Question> questions;
        if (numQuestions != null && numQuestions > 0) {
            questions = questionRepository.findRandomQuestions(numQuestions);
        } else {
            questions = questionRepository.findAll(); // Retrieve all questions if numQuestions is not specified
        }

        int timeLimit = questions.size() * 60;
        QuizTimer quizTimer = new QuizTimer(timeLimit);

        QuestionForm questionForm = new QuestionForm();
        questionForm.setQuestions(questions);

        model.addAttribute("qForm", questionForm);
        model.addAttribute("quizTimer", quizTimer);

        return "QuizView";
    }

}