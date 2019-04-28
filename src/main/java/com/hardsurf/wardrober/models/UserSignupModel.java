package com.hardsurf.wardrober.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserSignupModel {
    @NotNull
    @NotEmpty
    private String nickName;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    public UserSignupModel(@NotNull @NotEmpty String nickName,
                           @NotNull @NotEmpty String email,
                           @NotNull @NotEmpty String password) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
