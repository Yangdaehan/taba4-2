package com.example.taba42.dto;

import lombok.Getter;

@Getter
public class SignUpRequest {

    private String name;

    private int age;

    private String mid;

    private String password;

    private String phoneNumber;

    public SignUpRequest() {
    }

    public SignUpRequest(String name, int age, String mid, String password, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.mid = mid;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
