package com.example.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberLoginResponseDto {
    private String memberId;
    private String password;
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
