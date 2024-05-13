package org.example.springdeveloper.repository;

import org.example.springdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);   // 사용자의 이메일로 구분 이메일은고유 하고 이메일로 시큐리티가 전달받아야 함
}
