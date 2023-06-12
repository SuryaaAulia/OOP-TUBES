package com.QuiZZila.Tubes.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.QuiZZila.Tubes.main.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}