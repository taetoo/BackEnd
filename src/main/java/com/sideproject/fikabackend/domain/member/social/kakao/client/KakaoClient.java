package com.sideproject.fikabackend.domain.member.social.kakao.client;


import com.sideproject.fikabackend.domain.member.social.kakao.dto.KakaoInfo;
import com.sideproject.fikabackend.domain.member.social.kakao.dto.KakaoToken;
import com.sideproject.fikabackend.domain.member.social.kakao.config.KakaoFeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(name = "kakaoClient", configuration = KakaoFeignConfiguration.class)
public interface KakaoClient {

    @PostMapping
    KakaoInfo getInfo(URI baseUrl, @RequestHeader("Authorization") String accessToken);

    @PostMapping
    KakaoToken getToken(URI baseUrl, @RequestParam("client_id") String restApiKey,
                        @RequestParam("redirect_uri") String redirectUrl,
                        @RequestParam("code") String code,
                        @RequestParam("grant_type") String grantType);

}