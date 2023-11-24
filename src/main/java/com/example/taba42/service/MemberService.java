package com.example.taba42.service;

import com.example.taba42.domain.Member;
import com.example.taba42.dto.SignUpRequest;
import com.example.taba42.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void addMember(SignUpRequest request) {
        final Member member = Member.from(request);
        memberRepository.save(member);
    }
}
