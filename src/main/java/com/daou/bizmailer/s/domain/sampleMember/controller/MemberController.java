package com.daou.bizmailer.s.domain.sampleMember.controller;

import com.daou.bizmailer.s.domain.sampleMember.model.MemberModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    final String PREFIX = "/mbmers";

    @ResponseBody
    @RequestMapping(value = PREFIX, method = {RequestMethod.POST})
    public String createMember(@RequestBody MemberModel member) {
        return "";
    }

    @ResponseBody
    @RequestMapping(value = PREFIX + "/{id}", method = {RequestMethod.DELETE})
    public void removeMember(@PathVariable Long id) {

    }

    @ResponseBody
    @RequestMapping(value = PREFIX + "/{id}", method = {RequestMethod.GET})
    public String getMember(@PathVariable Long id) {
        return "";
    }

    @ResponseBody
    @RequestMapping(value = PREFIX + "/{id}", method = {RequestMethod.PUT})
    public String updateMember(@PathVariable Long id, @RequestBody MemberModel member) {
        return "";
    }
}
