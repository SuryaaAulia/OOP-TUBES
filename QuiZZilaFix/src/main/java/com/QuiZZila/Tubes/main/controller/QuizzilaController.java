package com.QuiZZila.Tubes.main.controller;

import java.util.List;

import com.QuiZZila.Tubes.main.model.*;

import com.QuiZZila.Tubes.main.service.CalculateHasil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class QuizzilaController {

	@Autowired
	Hasil hasil;

	@Autowired
	CalculateHasil quizService;

	Boolean submitted = false;

	@ModelAttribute("result")
	public Hasil getResult() {
		return hasil;
	}

	@GetMapping("/")
	public String home() {
		return "LandingPageView";
	}

	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm) {
		if (!submitted) {
			hasil.setTotalCorrect(quizService.getResult(qForm)); // Menghitung total jawaban yang benar menggunakan ExtendedQuizService
			quizService.saveScore(hasil); // Menyimpan skor
			submitted = true;
		}
		return "HasilView";
	}

	@GetMapping("/leaderboard")
	public String score(Model model) {
		List<Hasil> sList = quizService.getTopScore();
		model.addAttribute("sList", sList);

		return "LeaderboardView";
	}

	@GetMapping("/selectedQuestion")
	public String selectedQuestion() {
		return "selectedQuestion";
	}
}
