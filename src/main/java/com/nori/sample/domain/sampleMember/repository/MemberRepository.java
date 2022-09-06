package com.nori.sample.domain.sampleMember.repository;

import com.nori.sample.domain.sampleMember.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
