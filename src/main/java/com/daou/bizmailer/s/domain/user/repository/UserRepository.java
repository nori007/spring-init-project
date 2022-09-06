package com.daou.bizmailer.s.domain.user.repository;

import com.daou.bizmailer.s.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
