package com.hardsurf.wardrober.models;

import com.hardsurf.wardrober.persistence.dto.UserDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserModel {

    @NotNull
    @NotEmpty
    private String nickName;

    @NotNull
    @NotEmpty
    private String email;

    public UserModel(@NotNull @NotEmpty String nickName,
                     @NotNull @NotEmpty String email) {
        this.nickName = nickName;
        this.email = email;
    }

    public UserModel(@NotNull UserDto userDto) {
        this(userDto.getNickName(), userDto.getEmail());
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
