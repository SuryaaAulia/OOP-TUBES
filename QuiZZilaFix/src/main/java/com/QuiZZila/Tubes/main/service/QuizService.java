package com.QuiZZila.Tubes.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.QuiZZila.Tubes.main.model.Hasil;
import com.QuiZZila.Tubes.main.model.Question;
import com.QuiZZila.Tubes.main.repository.HasilRepository;
import com.QuiZZila.Tubes.main.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.QuiZZila.Tubes.main.model.QuestionForm;

@Service
public class QuizService extends QuizAbstrak{
	@Autowired
	HasilRepository hasilRepository;

	@Override
	public int getResult(QuestionForm qForm) {
		int correct = 0;

		for (Question q : qForm.getQuestions()) {
			if (q.getAns() == q.getChose()) {
				correct++;
			}
		}
		return correct;
	}

	@Override
	public void saveScore(Hasil hasil) {
		Hasil saveHasil = new Hasil();
		saveHasil.setUsername(hasil.getUsername());
		saveHasil.setTotalCorrect(hasil.getTotalCorrect());
		hasilRepository.save(saveHasil);
	}

	@Override
	public List<Hasil> getTopScore() {
		return hasilRepository.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
	}
}
