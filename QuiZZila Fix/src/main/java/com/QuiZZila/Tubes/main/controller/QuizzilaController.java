package com.QuiZZila.Tubes.main.controller;

import java.util.List;

import com.QuiZZila.Tubes.main.model.Hasil;
import com.QuiZZila.Tubes.main.model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.QuiZZila.Tubes.main.model.QuestionForm;
import com.QuiZZila.Tubes.main.repository.QuestionRepository;
import com.QuiZZila.Tubes.main.service.QuizService;

@Controller
public class QuizzilaController {

	@Autowired
	Hasil hasil;
	@Autowired
	QuizService quizService;
	@Autowired
	QuestionRepository questionRepository;
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
		if (username.equals("")) {
			ra.addFlashAttribute("warning", "Tolong masukkan nama!");
			return "redirect:/";
		}

		submitted = false;
		hasil.setUsername(username);

		List<Question> questions = questionRepository.findAll();

		QuestionForm questionForm = new QuestionForm();
		questionForm.setQuestions(questions);
		m.addAttribute("qForm", questionForm);

		return "QuizView";
	}

	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm) {
		if (!submitted) {
			hasil.setTotalCorrect(quizService.getResult(qForm));
			quizService.saveScore(hasil);
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

	@GetMapping("/login")
	public String login() {
		return "LoginView";
	}

	@GetMapping("/addQuestion")
	public String addQuestion(Model model) {
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
		return "redirect:/";
	}
}
