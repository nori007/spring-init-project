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
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(new MemberResponseDto());
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<String> removeMember(@PathVariable Long id) {
        return ResponseEntity.ok(id.toString());
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(new MemberResponseDto());
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long id, @RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(new MemberResponseDto());
    }

    @ResponseBody
    @RequestMapping(value = "/me", method = {RequestMethod.GET})
    public ResponseEntity<MemberResponseDto> getCurrentUser() {
        return ResponseEntity.ok(memberService.getCurrentUserInfo());
    }
}
