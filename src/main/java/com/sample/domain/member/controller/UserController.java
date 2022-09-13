package com.sample.domain.member.controller;

import com.sample.domain.member.dto.MemberRequestDto;
import com.sample.domain.member.dto.MemberResponseDto;
import com.sample.domain.member.service.MemeberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final MemeberService memeberService;

    @RequestMapping(method = {RequestMethod.POST})
    public MemberResponseDto createUser(@RequestBody MemberRequestDto memberRequestDto) {
        return new MemberResponseDto();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public String removeMUser(@PathVariable Long id) {
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public MemberResponseDto getUser(@PathVariable Long id) {
        return new MemberResponseDto();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    public MemberResponseDto updateUser(@PathVariable Long id, @RequestBody MemberRequestDto memberRequestDto) {
        return new MemberResponseDto();
    }

    @ResponseBody
    @RequestMapping(value = "/me", method = {RequestMethod.GET})
    public ResponseEntity<MemberResponseDto> getCurrentUser() {
        return ResponseEntity.ok(memeberService.getCurrentUserInfo());
    }
}
