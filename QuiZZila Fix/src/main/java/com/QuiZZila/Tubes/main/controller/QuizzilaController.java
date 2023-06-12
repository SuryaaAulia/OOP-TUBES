package com.QuiZZila.Tubes.main.controller;

import java.util.List;

import com.QuiZZila.Tubes.main.model.Hasil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.QuiZZila.Tubes.main.model.QuestionForm;
import com.QuiZZila.Tubes.main.service.QuizService;

@Controller
public class QuizzilaController {
	
	@Autowired
	Hasil hasil;
	@Autowired
	QuizService quizService;
	Boolean submitted = false;
	
	@ModelAttribute("result")
	public Hasil getResult() {
		return hasil;
	}
	
	@GetMapping("/")
	public String home() {
		return "LandingPageView";
	}
	
	@PostMapping("/quiz")
	public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
		if(username.equals("")) {
			ra.addFlashAttribute("warning", "You must enter your name");
			return "redirect:/";
		}
		
		submitted = false;
		hasil.setUsername(username);
		
		QuestionForm qForm = quizService.getQuestions();
		m.addAttribute("qForm", qForm);
		
		return "QuizView";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m) {
		if(!submitted) {
			hasil.setTotalCorrect(quizService.getResult(qForm));
			quizService.saveScore(hasil);
			submitted = true;
		}
		
		return "HasilView";
	}
	
	@GetMapping("/leaderboard")
	public String score(Model m) {
		List<Hasil> sList = quizService.getTopScore();
		m.addAttribute("sList", sList);
		
		return "LeaderboardView";
	}
}
