package com.QuiZZila.tubes.Controller;

import com.QuiZZila.tubes.Model.Answer;
import com.QuiZZila.tubes.Model.Question;
import com.QuiZZila.tubes.Model.Quiz;
import com.QuiZZila.tubes.Repository.AnswerRepository;
import com.QuiZZila.tubes.Repository.QuestionRepository;
import com.QuiZZila.tubes.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class addQuizController {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public addQuizController(QuizRepository quizRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @GetMapping("/addQuiz")
    public String showAddQuizForm(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "addQuizView";
    }

    @PostMapping("/addQuiz")
    public String addQuiz(@ModelAttribute("quiz") @Validated Quiz quiz, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addQuizView";
        }

        Quiz savedQuiz = quizRepository.save(quiz);

        List<Question> questions = quiz.getQuestions();
        List<Question> savedQuestions = new ArrayList<>();

        for (Question question : questions) {
            question.setQuiz(savedQuiz);
            Question savedQuestion = questionRepository.save(question);
            savedQuestions.add(savedQuestion);

            List<Answer> answers = question.getAnswers();
            List<Answer> savedAnswers = new ArrayList<>();

            for (Answer answer : answers) {
                answer.setQuestion(savedQuestion);
                Answer savedAnswer = answerRepository.save(answer);
                savedAnswers.add(savedAnswer);
            }

            savedQuestion.setAnswers(savedAnswers);

            Answer correctOption = question.getCorrectOption();

            if (correctOption != null) {
                for (Answer answer : savedAnswers) {
                    if (answer.getId().equals(correctOption.getId())) {
                        correctOption = answer;
                        break;
                    }
                }
            }

            savedQuestion.setCorrectOption(correctOption);

            questionRepository.save(savedQuestion);
        }
        savedQuiz.setQuestions(savedQuestions);
        quizRepository.save(savedQuiz);

        return "redirect:/dashboard";
    }
}
