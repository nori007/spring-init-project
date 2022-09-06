package com.nori.sample.domain.user.repository;

import com.nori.sample.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
