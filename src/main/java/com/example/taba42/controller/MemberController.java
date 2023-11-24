package com.example.taba42.controller;

import com.example.taba42.dto.SignUpRequest;
import com.example.taba42.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signUp")
    ResponseEntity<Long> signUp(@RequestBody SignUpRequest request) {
        memberService.addMember(request);
        return ResponseEntity.ok().build();
    }
}
