package com.foody.be.auth.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}