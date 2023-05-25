package com.QuiZZila.tubes.Repository;

import com.QuiZZila.tubes.Model.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Integer> {
}
