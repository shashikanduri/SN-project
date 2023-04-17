package com.sn.SNProject.payloads;

public class PostResponse {

    private final String encryptedImg;
    private final String iv;

    public PostResponse(String encryptedImg, String iv) {
        this.encryptedImg = encryptedImg;
        this.iv = iv;
    }

    public String getEncryptedImg() {
        return encryptedImg;
    }

    public String getIv() {
        return iv;
    }
}
