package com.example.taba42.dto.response;

import com.example.taba42.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponse {

    private Long id;

    private String name;

    private int age;

    private String mid;

    private String phoneNumber;

    public MemberResponse(Long id, String name, int age, String mid, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mid = mid;
        this.phoneNumber = phoneNumber;
    }

    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMid(),
                member.getPhoneNumber()
        );
    }
}
