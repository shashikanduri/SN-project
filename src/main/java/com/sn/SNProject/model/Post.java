package com.sn.SNProject.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class Post {
    @Id @NotBlank
    private String imgSignature;
    private String imageData;
    private String userId;
    private String caption;

    public Post(String imgSignature, String imageData, String userId, String caption){
        this.imgSignature = imgSignature;
        this.imageData = imageData;
        this.userId = userId;
        this.caption = caption;
    }

    public String getImgSignature() {
        return imgSignature;
    }

    public String getImageData() {
        return imageData;
    }

    public String getUserId() {
        return userId;
    }

    public String getCaption() {
        return caption;
    }
}
