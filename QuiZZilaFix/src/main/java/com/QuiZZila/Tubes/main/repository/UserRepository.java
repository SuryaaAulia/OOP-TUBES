package com.QuiZZila.Tubes.main.repository;

import com.QuiZZila.Tubes.main.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
}
