package com.daou.bizmailer.s.domain.sampleMember.repository;

import com.daou.bizmailer.s.domain.sampleMember.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
