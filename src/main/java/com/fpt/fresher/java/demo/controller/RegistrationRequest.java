package com.fpt.fresher.java.demo.controller;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationRequest {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String role;
}