package com.sample.common.jwt;

import com.sample.domain.member.entity.Member;
import com.sample.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Disabled;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

@Disabled("This is for service layer test.")
public class BaseDataTest {

    @Mock
    MemberRepository memberRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    protected final String TEST_LOGINID = "123123123";
    protected final String TEST_PASSWORD = "1234";
    protected final String TEST_NAME = "testName";
    protected final String TEST_EMAIL = "test@email.com";


    protected void createMember() {
        memberRepository.save(
                Member.builder()
                        .loginId(TEST_LOGINID)
                        .password(passwordEncoder.encode(TEST_PASSWORD))
                        .name(TEST_NAME)
                        .email(TEST_EMAIL)
                        .build()
        );

        memberRepository.flush();
    }

    protected void deleteMember() {
        Member member = memberRepository.findByLoginId(TEST_EMAIL).orElseThrow(() -> new RuntimeException("not found member"));

        memberRepository.delete(member);

        memberRepository.flush();
    }
}
