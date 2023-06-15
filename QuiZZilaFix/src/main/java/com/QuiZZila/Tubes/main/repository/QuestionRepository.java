package com.QuiZZila.Tubes.main.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.QuiZZila.Tubes.main.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT :numQuestions", nativeQuery = true)
    List<Question> findRandomQuestions(@Param("numQuestions") int numQuestions);
}