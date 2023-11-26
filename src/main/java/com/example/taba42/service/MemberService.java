package com.example.taba42.service;

import com.example.taba42.domain.Member;
import com.example.taba42.dto.request.SignInRequest;
import com.example.taba42.dto.request.SignUpRequest;
import com.example.taba42.dto.response.MemberResponse;
import com.example.taba42.exception.MemberException;
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
    public Long signUp(SignUpRequest request) {
        final Member member = Member.from(request);

        if (memberRepository.existsByMid(request.getMid())) {
            throw new MemberException("중복된 아이디입니다.");
        }

        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public Long signIn(SignInRequest request) {
        Member member = memberRepository.findByMidAndPassword(request.getMid(), request.getPassword()).orElseThrow(
                () -> new MemberException("로그인 정보가 맞지 않습니다.")
        );
        return member.getId();
    }

    public MemberResponse memberInfo(Long memberId) {
        Member member = getMemberById(memberId);
        return MemberResponse.from(member);
    }

    private Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new MemberException("회원이 존재하지 않습니다.")
        );
    }
}
