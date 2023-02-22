package com.sideproject.fikabackend.domain.user.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@Getter
public class UserRequestDto {

    private String uId;
    private String pw;
    private Long userName;
    private String nickName;
    private String region;
    private int age;
}