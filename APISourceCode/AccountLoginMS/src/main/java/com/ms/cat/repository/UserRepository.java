package com.ms.cat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ms.cat.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

}
