package com.QuiZZila.tubes.Repository;

import com.QuiZZila.tubes.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
