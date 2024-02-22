package com.example.demo.service;

import com.example.demo.dto.CaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class CaptchaService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${FriendlyCaptcha.CaptchaKey}")
    private String captchaKey;
    @Value("${FriendlyCaptcha.SiteKey}")
    private String siteKey;
    public CaptchaResponse verificarCaptcha(String solution) {
        String url="https://api.friendlycaptcha.com/api/v1/siteverify";
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(
                MediaType.APPLICATION_JSON
        );
        Map<String,String> requestVody=new HashMap<>();
        requestVody.put("solution",solution);
        requestVody.put("secret",captchaKey);
        requestVody.put("sitekey",siteKey);
        HttpEntity<Map<String,String>> requestEntity=
                new HttpEntity<>(requestVody,headers);
        ResponseEntity<CaptchaResponse> responseEntity=
                restTemplate.postForEntity(url,requestEntity,CaptchaResponse.class);
        return responseEntity.getBody();


    }
}
