package com.sample.domain.member.service;

import com.sample.common.security.SecurityUtil;
import com.sample.domain.member.dto.MemberResponseDto;
import com.sample.domain.member.entity.Member;
import com.sample.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemeberService {

    @Autowired
    MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResponseDto getUserInfo(Long id) {
        return memberRepository.findById(id).map(MemberResponseDto::of).orElseThrow(() -> new RuntimeException("not found user"));
    }

    @Transactional(readOnly = true)
    public MemberResponseDto getCurrentUserInfo() {
        return memberRepository.findByLoginId(SecurityUtil.getCurrentUserLoginId()).map(MemberResponseDto::of).orElseThrow(() -> new RuntimeException("not found login user"));
    }
}
