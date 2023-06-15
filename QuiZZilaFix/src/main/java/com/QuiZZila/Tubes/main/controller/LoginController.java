package com.QuiZZila.Tubes.main.controller;

import com.QuiZZila.Tubes.main.model.Hasil;
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
public class LoginController {

    @Autowired
    UserService userService;
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute("users");
        if(users == null){
            model.addAttribute("email", "");
            model.addAttribute("password", "");
            return "LoginView";
        }
        return "redirect:/";
    }
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request) {
        Users users = userService.findUserByEmail(email);
        if (users != null && users.getPassword().equals(password)) {
            request.getSession().setAttribute("users", users);
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
