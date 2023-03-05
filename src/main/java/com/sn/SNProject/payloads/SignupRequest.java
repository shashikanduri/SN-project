package com.sn.SNProject.payloads;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class SignupRequest {
    @Email
    private final String email;

    @Size(min = 6, max = 12)
    private final String password;

    private final String fullName;

    public SignupRequest(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;

    }

    public String getEmail() {
        return email;
    }
    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
}
