package com.sample.common.jwt.controller;

import com.sample.common.jwt.dto.TokenRequestDto;
import com.sample.common.jwt.dto.TokenResponseDto;
import com.sample.common.jwt.service.AuthService;
import com.sample.domain.member.dto.MemberRequestDto;
import com.sample.domain.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController extends AuthControllerExceptionHandler{

    private final AuthService authservice;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authservice.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authservice.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenResponseDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authservice.reissue(tokenRequestDto));
    }
}
