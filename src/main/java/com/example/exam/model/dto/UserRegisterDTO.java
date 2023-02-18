package com.example.exam.model.dto;

import com.example.exam.validation.annotations.UniqueEmail;
import com.example.exam.validation.annotations.UniqueUserName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @UniqueUserName
    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 3,max = 20)
    private String username;

    @UniqueEmail
    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Email must be valid!")
    private String email;

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotBlank(message = "Confirm Password cannot be empty!")
    @Size(min = 3,max = 20,message = "Confirm Password length must be between 3 and 20 characters!")
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegisterDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
