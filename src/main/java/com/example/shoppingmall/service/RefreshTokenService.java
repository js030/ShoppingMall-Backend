package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.RefreshToken;
import com.example.shoppingmall.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public void saveRefreshToken(String userId, String refreshToken){

        RefreshToken refresh = new RefreshToken(userId, refreshToken);
        refreshTokenRepository.save(refresh);
    }

}
