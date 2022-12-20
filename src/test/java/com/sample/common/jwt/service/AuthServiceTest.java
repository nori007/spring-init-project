package com.sample.common.jwt.service;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;
import com.sample.common.jwt.dto.TokenResponseDto;
import com.sample.common.jwt.entity.RefreshToken;
import com.sample.common.jwt.repository.RefreshTokenRepository;
import com.sample.domain.member.dto.MemberRequestDto;
import com.sample.domain.member.dto.MemberResponseDto;
import com.sample.domain.member.entity.Member;
import com.sample.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private RefreshTokenRepository refreshTokenRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    private String LOGINID = "member_test_login_id";
    private String PASSWORD = "member_test_password";
    private String NAME = "member_test_name";
    private String EMAIL = "member_test_email";
    
    @Test
    @DisplayName("회원가입")
    public void 가입() throws Exception{
        // given
        Member member = createMember();
        MemberRequestDto memberRequestDto = new MemberRequestDto("testLoginId", "1qaz2wsx#", "testName", "test@test.com");
        when(memberRepository.existsByEmail(any(String.class))).thenReturn(false);
        when(memberRepository.save(any(Member.class))).thenReturn(member);

        
        // when
        MemberResponseDto memberResponseDto = authService.signup(memberRequestDto);

        // then
        Assertions.assertNotNull(memberResponseDto.getId());
    }

    @Test
    @DisplayName("로그인")
    public void 로그인() {
        // given
        Member member = createMember();
        MemberRequestDto memberRequestDto = new MemberRequestDto("testLoginId", "1qaz2wsx#", "testName", "test@test.com");
        when(memberRepository.findByLoginId(any())).thenReturn(Optional.of(member));
        when(passwordEncoder.matches(memberRequestDto.getPassword(), member.getPassword())).thenReturn(true);
        when(refreshTokenRepository.save(any(RefreshToken.class))).thenReturn(any(RefreshToken.class));

        // when
        TokenResponseDto tokenResponseDto = authService.login(memberRequestDto);

        // then
        Assertions.assertNotNull(tokenResponseDto);
    }

    @Test
    @DisplayName("로그인 - 실패")
    public void 로그인_실패() {
        // given
        Member member = createMember();
        MemberRequestDto memberRequestDto = new MemberRequestDto("testLoginId", "1qaz2wsx#", "testName", "test@test.com");
        when(memberRepository.findByLoginId(any())).thenReturn(Optional.of(member));
        when(passwordEncoder.matches(memberRequestDto.getPassword(), member.getPassword())).thenReturn(false);

        BaseException exception = Assertions.assertThrows(BaseException.class, () -> {
            authService.login(memberRequestDto);
        });

        // then
        Assertions.assertEquals(ErrorCodeEnum.INVALID_ARGUMENT_EXCEPTION, exception.getError());
    }


    private Member createMember() {

        Member member = Member.builder()
                .loginId(LOGINID)
                .password(passwordEncoder.encode(PASSWORD))
                .name(NAME)
                .email(EMAIL)
                .build();
        ReflectionTestUtils.setField(member, "id", 1L);

        return member;
    }    
}
