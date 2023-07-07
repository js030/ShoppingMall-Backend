package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.MemberSignUpDto;
import com.example.shoppingmall.dto.TokenInfo;
import com.example.shoppingmall.entity.Member;
import com.example.shoppingmall.jwt.JwtTokenProvider;
import com.example.shoppingmall.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;


    public void memberSave(MemberSignUpDto memberSignUpDto){
        Member member = new Member(memberSignUpDto.getMemberId(), memberSignUpDto.getPassword());
        memberRepository.save(member);
    }

    @Transactional
    public TokenInfo login(String memberId, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.generateToken(authentication);
    }
}
