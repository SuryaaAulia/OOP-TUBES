package com.QuiZZila.Tubes.main.controller;

import java.util.List;

<<<<<<< Updated upstream
import com.QuiZZila.Tubes.main.model.Hasil;
import com.QuiZZila.Tubes.main.model.Question;
=======
import com.QuiZZila.Tubes.main.model.*;
import com.QuiZZila.Tubes.main.repository.QuestionRepository;
import com.QuiZZila.Tubes.main.service.QuizService;
>>>>>>> Stashed changes

import com.QuiZZila.Tubes.main.service.UserService;
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

import javax.servlet.http.HttpServletRequest;

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

<<<<<<< Updated upstream
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
=======
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserService usersService;
    Boolean submitted = false;
>>>>>>> Stashed changes

		submitted = false;
		hasil.setUsername(username);

		List<Question> questions = questionRepository.findAll();

		QuestionForm questionForm = new QuestionForm();
		questionForm.setQuestions(questions);
		m.addAttribute("qForm", questionForm);

		return "QuizView";
	}

<<<<<<< Updated upstream
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
=======
        List<Question> questions = questionRepository.findAll();
        QuestionForm questionForm = new QuestionForm();

        int timeLimit = questions.size()*60;

        QuizTimer quizTimer = new QuizTimer(timeLimit);

        questionForm.setQuestions(questions);
        model.addAttribute("qForm", questionForm);
        model.addAttribute("quizTimer", quizTimer);
>>>>>>> Stashed changes

	@GetMapping("/login")
	public String login() {
		return "LoginView";
	}

<<<<<<< Updated upstream
	@GetMapping("/addQuestion")
	public String addQuestion(Model model) {
		model.addAttribute("title", "");
		model.addAttribute("optionA", "");
		model.addAttribute("optionB", "");
		model.addAttribute("optionC", "");
		model.addAttribute("ans", 0);
=======
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
        Users users = usersService.findUserByEmail(email);
        if (users != null && users.getPassword().equals(password)) {
            request.getSession().setAttribute("users", users);
            return "redirect:/";
        }
        return "redirect:/login";
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
>>>>>>> Stashed changes

		return "addQuestion";
	}

<<<<<<< Updated upstream
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
=======
        return "LeaderboardView";
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
>>>>>>> Stashed changes
}
