package com.QuiZZila.Tubes.main.repository;

import com.QuiZZila.Tubes.main.model.Hasil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HasilRepository extends JpaRepository<Hasil, Integer> {
	
}
