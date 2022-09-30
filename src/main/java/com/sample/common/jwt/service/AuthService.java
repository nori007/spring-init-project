package com.sample.common.jwt.service;

import com.sample.common.jwt.JwtUtil;
import com.sample.common.jwt.dto.TokenRequestDto;
import com.sample.common.jwt.dto.TokenResponseDto;
import com.sample.common.jwt.entity.RefreshToken;
import com.sample.common.jwt.repository.RefreshTokenRepository;
import com.sample.domain.member.dto.MemberRequestDto;
import com.sample.domain.member.dto.MemberResponseDto;
import com.sample.domain.member.entity.Member;
import com.sample.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public MemberResponseDto signup(MemberRequestDto memberRequestDto) {
        if (memberRepository.existsByEmail(memberRequestDto.getEmail())) {
            throw new RuntimeException("이메일 중복");
        }

        Member member = memberRequestDto.toMember(passwordEncoder);

        return MemberResponseDto.of(memberRepository.save(member));
    }

    @Transactional
    public TokenResponseDto login(MemberRequestDto memberRequestDto) {
        Member member = memberRepository.findByLoginId(memberRequestDto.getLoginId()).orElseThrow(() -> new RuntimeException("error"));

        if (!passwordEncoder.matches(memberRequestDto.getPassword(), member.getPassword())) {
            throw new RuntimeException("password error");
        }

        TokenResponseDto tokenResponseDto = JwtUtil.create(memberRequestDto.getLoginId(), memberRequestDto.getName());

        RefreshToken refreshToken = RefreshToken.builder()
                .key(memberRequestDto.getLoginId())
                .value(tokenResponseDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        return tokenResponseDto;
    }

    @Transactional(readOnly = true)
    public TokenResponseDto reissue(TokenRequestDto tokenRequestDto) {
        
        String loginId = JwtUtil.getUserId(tokenRequestDto.getRefreshToken());
        if (loginId.isEmpty()) {
            throw new RuntimeException("refresh token is not valid");
        }

        RefreshToken refreshToken = refreshTokenRepository.findByKey(loginId)
                .orElseThrow(() -> new RuntimeException("logout user"));

        if (!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("token is not valid");
        }

        Member member = memberRepository.findByLoginId(loginId).orElseThrow(() -> new RuntimeException("not found user"));
        TokenResponseDto newTokenResponseDto = JwtUtil.create(member.getLoginId(), member.getName());

        RefreshToken newRefreshToken = refreshToken.updateValue(newTokenResponseDto.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        return newTokenResponseDto;
    }
}
