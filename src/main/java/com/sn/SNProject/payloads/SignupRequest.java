package com.sn.SNProject.payloads;


public class SignupRequest {
    private final String encryptedData;
    private final String userPublicKey;
    private final String iv;
    private final String rsaPublicKey;
    public SignupRequest(String userPublicKey, String encryptedData, String iv, String rsaPublicKey) {
        this.encryptedData = encryptedData;
        this.userPublicKey = userPublicKey;
        this.iv = iv;
        this.rsaPublicKey = rsaPublicKey;
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
    public String getRsaPublicKey() {return rsaPublicKey;}
}
