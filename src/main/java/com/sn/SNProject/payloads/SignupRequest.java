package com.sn.SNProject.payloads;


public class SignupRequest {
    private final String encryptedData;
    private final String userPublicKey;
    private final String iv;
    private final String tag;
    public SignupRequest(String userPublicKey, String encryptedData, String iv, String tag) {
        this.encryptedData = encryptedData;
        this.userPublicKey = userPublicKey;
        this.iv = iv;
        this.tag = tag;
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
    public String getTag(){ return tag; }
}
