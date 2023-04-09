package com.sn.SNProject.payloads;


public class LoginRequest {
    private final String encryptedData;
    private final String userPublicKey;
    private final String iv;

    public LoginRequest(String encryptedData, String userPublicKey, String iv) {
        this.encryptedData = encryptedData;
        this.userPublicKey = userPublicKey;
        this.iv = iv;
    }

    public String getUserPublicKey() {
        return userPublicKey;
    }
    public String getEncryptedData(){
        return encryptedData;
    }

    public String getIv() {
        return iv;
    }

}
