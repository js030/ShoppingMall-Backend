package com.example.shoppingmall.controller;


import com.example.shoppingmall.dto.MemberLoginRequestDto;
import com.example.shoppingmall.dto.MemberLoginResponseDto;
import com.example.shoppingmall.dto.MemberSignUpDto;
import com.example.shoppingmall.dto.TokenInfo;
import com.example.shoppingmall.service.MemberService;
import com.example.shoppingmall.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/api/signup")
    public ResponseEntity signUp(@RequestBody MemberSignUpDto memberSignUpDto){
        log.info(memberSignUpDto.getMemberId());
        log.info(memberSignUpDto.getPassword());
        memberService.memberSave(memberSignUpDto);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/api/signin")
    public MemberLoginResponseDto login(@RequestBody MemberLoginRequestDto memberLoginRequestDto){
        TokenInfo tokenInfo = memberService.login(memberLoginRequestDto.getMemberId(), memberLoginRequestDto.getPassword());

        String refreshToken = tokenInfo.getRefreshToken();
        refreshTokenService.saveRefreshToken(memberLoginRequestDto.getMemberId(), refreshToken);

        return new MemberLoginResponseDto(memberLoginRequestDto.getMemberId(), memberLoginRequestDto.getPassword(),
                tokenInfo.getGrantType(), tokenInfo.getAccessToken(), tokenInfo.getRefreshToken());
    }
}
