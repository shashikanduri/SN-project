package com.sn.SNProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String email;
    private String password;
    private String fullName;
    private String publicKey;

    public String encryptedData;
    public String clientPublicKey;

    public User( String email, @JsonProperty("pass") String password,
                @JsonProperty("name") String fullName, @JsonProperty("publicKey") String publicKey,
                @JsonProperty("data") String encryptedData, @JsonProperty("publicKey") String clientPublicKey) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.publicKey = publicKey;
        this.encryptedData = encryptedData;
        this.clientPublicKey = clientPublicKey;
    }

    public String getEmail() {
        return email;
    }
    public String getFullName() {
        return fullName;
    }
}
