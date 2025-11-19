package com.example.store.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name must not be blank")
    @Size(max = 255,message = "Name must be less than 255 characters")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please put a valid email")
    @LowerCase(message = "Email must be in lowercase")
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, max = 30, message = "Password but be between 6 to 30 characters")
    private String password;
}
