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
public class QuizService {

	@Autowired
	Question question;
	@Autowired
	QuestionForm qForm;
	@Autowired
	QuestionRepository qRepo;
	@Autowired
	Hasil hasil;
	@Autowired
	HasilRepository rRepo;

	public int getResult(QuestionForm qForm) {
		int correct = 0;

		for (Question q : qForm.getQuestions())
			if (q.getAns() == q.getChose())
				correct++;
		return correct;
	}

	public void saveScore(Hasil hasil) {
		Hasil saveHasil = new Hasil();
		saveHasil.setUsername(hasil.getUsername());
		saveHasil.setTotalCorrect(hasil.getTotalCorrect());
		rRepo.save(saveHasil);
	}

	public List<Hasil> getTopScore() {
		return rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
	}
}
