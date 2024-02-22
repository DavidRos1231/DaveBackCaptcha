package com.example.demo.controller;

import com.example.demo.dto.CaptchaResponse;
import com.example.demo.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.POST,RequestMethod.OPTIONS}
)
@RequestMapping("/api/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    @PostMapping("/verificar-captcha")
    public CaptchaResponse verificarCaptcha(@RequestParam("solution") String solution){
        return captchaService.verificarCaptcha(solution);
    }
}
