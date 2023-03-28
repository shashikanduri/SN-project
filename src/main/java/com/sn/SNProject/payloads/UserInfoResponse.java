package com.sn.SNProject.payloads;
public class UserInfoResponse {
    private String fullName;
    private String email;
    private String sessionId;

    public UserInfoResponse(String fullName, String email, String sessionId){
        this.fullName = fullName;
        this.email = email;
        this.sessionId = sessionId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getSessionId() {
        return sessionId;
    }
}
