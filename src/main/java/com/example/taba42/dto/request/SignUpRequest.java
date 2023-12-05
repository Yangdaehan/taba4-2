package com.example.taba42.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class SignUpRequest {

    //@NotBlank
    @Pattern(regexp = "^[가-힣]{2,4}$",
            message = "이름은 한국 이름으로 2~4글자 까지 가능합니다.")
    private String name;

    @NotNull
    private int age;

    @Email(message = "아이디는 이메일 형식이여야합니다.")
    //@NotBlank
    private String mid;

   // @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{9,16}",
            message = "비밀번호는 영문, 숫자, 특수기호가 적어도 1개 이상씩 포함된 9자 ~ 16자의 비밀번호여야 합니다.")
    private String password;

    //@NotBlank
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
