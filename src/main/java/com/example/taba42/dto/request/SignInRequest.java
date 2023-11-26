package com.example.taba42.dto.request;

import lombok.Getter;

@Getter
public class SignInRequest {

    private String mid;

    private String password;

    public SignInRequest() {
    }

    public SignInRequest(String mid, String password) {
        this.mid = mid;
        this.password = password;
    }
}
