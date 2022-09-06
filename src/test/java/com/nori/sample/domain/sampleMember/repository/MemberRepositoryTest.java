package com.nori.sample.domain.sampleMember.repository;

import com.nori.sample.domain.sampleMember.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMemberSave() throws Exception {
        Member member = Member.builder().name("hyunggil89").email("hyunggil89@daou.co.kr").build();

        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId())
                .orElseThrow(() -> new IllegalArgumentException("not found data"));

        Assertions.assertThat(findMember.getId()).isEqualTo(saveMember.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(saveMember.getName());
    }
}
