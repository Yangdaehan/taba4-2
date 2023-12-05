package com.example.taba42.domain;

import com.example.taba42.dto.request.SignUpRequest;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Table(name = "member")
@Entity
public class Member {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //@Column(name="aassssssa")
    @NotNull
    private String name;

    //@Column(name="aasdfadsfasfaa")
    @NotNull
    private int age;

    //@Column(name="aassdfsdfa")
    @Email
    private String mid;

    //@Column(name="ssddssdsdsdaaa")
    @NotNull
    private String password;

    //@Column(name="aaddddddddda")
    @NotNull
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
