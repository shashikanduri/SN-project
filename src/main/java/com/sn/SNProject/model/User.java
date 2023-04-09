package com.sn.SNProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String email;
    private String password;
    private String userPublicKey;
    private String fullName;
    private String rsaPublicKey;
    private String sessionId;

    public User(String email, String password, String fullName, String userPublicKey, String rsaPublicKey) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.userPublicKey = userPublicKey;
        this.rsaPublicKey = rsaPublicKey;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRsaPublicKey() { return rsaPublicKey; }

}
