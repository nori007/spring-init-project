package com.sample.domain.member.repository;

import com.sample.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);
    Optional<Member> findByLoginId(String loginId);
    boolean existsByEmail(String email);
}
