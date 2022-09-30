package com.sample.domain.member.controller;

import com.sample.domain.member.dto.MemberRequestDto;
import com.sample.domain.member.dto.MemberResponseDto;
import com.sample.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @RequestMapping(method = {RequestMethod.POST})
    public MemberResponseDto createMember(@RequestBody MemberRequestDto memberRequestDto) {
        return new MemberResponseDto();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public String removeMember(@PathVariable Long id) {
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public MemberResponseDto getMember(@PathVariable Long id) {
        return new MemberResponseDto();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    public MemberResponseDto updateMember(@PathVariable Long id, @RequestBody MemberRequestDto memberRequestDto) {
        return new MemberResponseDto();
    }

    @ResponseBody
    @RequestMapping(value = "/me", method = {RequestMethod.GET})
    public ResponseEntity<MemberResponseDto> getCurrentUser() {
        return ResponseEntity.ok(memberService.getCurrentUserInfo());
    }
}
