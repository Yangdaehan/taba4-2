package com.example.taba42.domain;

import com.example.taba42.dto.SignUpRequest;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "member")
@Entity
public class Member {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String name;

    private int age;

    private String mid;

    private String password;

    private String phoneNumber;

    protected Member() {
    }

    public Member(String name, int age, String mid, String password, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.mid = mid;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public static Member from(SignUpRequest request) {
        return new Member(
                request.getName(),
                request.getAge(),
                request.getMid(),
                request.getPassword(),
                request.getPhoneNumber()
        );
    }

}
