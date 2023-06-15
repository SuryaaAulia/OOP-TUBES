package com.QuiZZila.Tubes.main.service;

import com.QuiZZila.Tubes.main.model.Hasil;
import com.QuiZZila.Tubes.main.model.QuestionForm;

import java.util.List;

public abstract class QuizAbstrak {

    public abstract int getResult(QuestionForm qForm);

    public abstract void saveScore(Hasil hasil);

    public abstract List<Hasil> getTopScore();

}

