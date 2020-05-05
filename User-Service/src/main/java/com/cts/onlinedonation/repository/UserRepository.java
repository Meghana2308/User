package com.cts.onlinedonation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.onlinedonation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findUserByUsername(String username);
}
