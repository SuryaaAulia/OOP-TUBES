package com.QuiZZila.Tubes.main.service;

import com.QuiZZila.Tubes.main.model.QuestionForm;
import org.springframework.stereotype.Service;

@Service
public class CalculateHasil extends QuizService{
    @Override
    public int getResult(QuestionForm qForm) {
        int correct = super.getResult(qForm);
        return correct * 10;
    }
}
