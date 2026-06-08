package com.vinny.project.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserSignInRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
