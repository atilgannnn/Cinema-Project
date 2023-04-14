package com.runners.cinema.dto.request;

import com.runners.cinema.dto.response.ValidMessages;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoginRequest {

    @Email(message = ValidMessages.EMAIL_ENTER)
    private String email;

    @NotBlank(message = ValidMessages.PASSWORD_ENTER)
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,15})",
            message =ValidMessages.PASSWORD_REGEX )
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
