package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CaptchaResponse {
    private boolean succes;
    private List<String> errors;
}
