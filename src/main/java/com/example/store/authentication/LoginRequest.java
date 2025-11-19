package com.example.store.authentication;

import com.example.store.users.LowerCase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Email must not be blank")
    @Email
    @LowerCase(message = "Email must be in lowercase")
    private String email;

    @NotBlank(message = "Password must not be blank")
    private String password;
}
