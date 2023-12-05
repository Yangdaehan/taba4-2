package com.example.taba42.controller;

import com.example.taba42.dto.response.MemberResponse;
import com.example.taba42.dto.request.SignInRequest;
import com.example.taba42.dto.request.SignUpRequest;
import com.example.taba42.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signUp")
    ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest request) {
        Long memberId = memberService.signUp(request);
        return ResponseEntity.ok().body("회원가입이 완료되었습니다");
    }

    @PostMapping("/signIn")
    ResponseEntity<Long> signIn(@RequestBody SignInRequest request) {
        Long memberId = memberService.signIn(request);
        return ResponseEntity.ok().body(memberId);
    }

    @GetMapping("{memberId}")
    ResponseEntity<MemberResponse> memberInfo(@PathVariable Long memberId) {
        MemberResponse memberResponse = memberService.memberInfo(memberId);
        return ResponseEntity.ok().body(memberResponse);
    }
}
