package com.sample.domain.member.dto;

import com.sample.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {

    private String loginId;
    private String password;
    private String name;
    private String email;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .loginId(loginId)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .build();
    }
}
