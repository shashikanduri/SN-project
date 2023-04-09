package com.sn.SNProject.payloads;

public class PostRequest {
    private final String encryptedImage;
    private final String rsaPublicKey;
    private final String imgSignature;
    private final String userId;
    private final String iv;
    private final String caption;

    public PostRequest(String encryptedImage, String rsaPublicKey, String imgSignature, String userId, String iv, String caption) {
        this.encryptedImage = encryptedImage;
        this.rsaPublicKey = rsaPublicKey;
        this.imgSignature = imgSignature;
        this.userId = userId;
        this.iv = iv;
        this.caption = caption;
    }

    public String getEncryptedImage() {
        return encryptedImage;
    }

    public String getImgSignature() {
        return imgSignature;
    }

    public String getUserId() {
        return userId;
    }

    public String getRsaPublicKey() {
        return rsaPublicKey;
    }

    public String getIv() {
        return iv;
    }

    public String getCaption() {
        return caption;
    }
}
