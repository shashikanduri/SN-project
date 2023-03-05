package com.sn.SNProject.services;

import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Base64;

@Service
public class DiffieHellman {
    public void createKeys() throws NoSuchAlgorithmException, IOException {

        // Generate the server's public/private key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DiffieHellman");
        keyPairGenerator.initialize(256);
        KeyPair serverKeyPair = keyPairGenerator.generateKeyPair();
        PublicKey serverPublicKey = serverKeyPair.getPublic();
        PrivateKey serverPrivateKey = serverKeyPair.getPrivate();
        File pub = new File("public.txt");
        FileOutputStream fos = new FileOutputStream(pub);

        byte[] publicKeyBytes = serverPublicKey.getEncoded();
        fos.write(publicKeyBytes);
        fos.close();
        File pri = new File("private.txt");
        FileOutputStream fos1 = new FileOutputStream(pri);

        byte[] privateKeyBytes = serverPrivateKey.getEncoded();
        fos1.write(privateKeyBytes);
        fos1.close();

    }
    public String decrypt(String clientPublicKey, String data) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, IOException {

        byte[] secretKey = generateSecretKey(clientPublicKey);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "AES");

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedDataBytes = cipher.doFinal(data.getBytes());

        return new String(decryptedDataBytes, StandardCharsets.UTF_8);
    }
    public byte[] getServerPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {

        File file = new File("public.txt");
        byte[] publicKeyBytes = Files.readAllBytes(file.toPath());

        KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKeyBytes);

        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

        return publicKey.getEncoded();
    }

    public byte[] generateSecretKey(String clientPublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, InvalidKeyException {

        byte[] clientPublicKeyBytes = Base64.getDecoder().decode(clientPublicKey);

        KeyFactory keyFactory = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(clientPublicKeyBytes);

        PublicKey clientPublicKeyType = keyFactory.generatePublic(x509KeySpec);
        /*
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DiffieHellman");
        byte[] serverPrivateBytes = Files.readAllBytes(Path.of("private.txt"));
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(serverPrivateBytes);
        PrivateKey serverPrivateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        keyAgreement.init(serverPrivateKey);
        keyAgreement.doPhase(clientPublicKeyType, true);
        byte[] sharedSecretKey = keyAgreement.generateSecret();
        System.out.println(sharedSecretKey.toString());
        return sharedSecretKey;
        */
         return clientPublicKeyType.getEncoded();
    }
}
