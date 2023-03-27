package com.sn.SNProject.services;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.*;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.security.spec.*;
import java.util.Arrays;
import java.util.Base64;

import static ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray;
import static ch.qos.logback.core.encoder.ByteArrayUtil.toHexString;


@Service
public class DiffieHellman {

    public DHParameterSpec modp15() {
        final BigInteger p =
                new BigInteger(
                                "ffffffffffffffffc90fdaa22168c234c4c6628b80dc1cd129024e088a67cc74020bbea63b139b22514a08798e3404ddef9519b3cd3a431b302b0a6df25f14374fe1356d6d51c245e485b576625e7ec6f44c42e9a637ed6b0bff5cb6f406b7edee386bfb5a899fa5ae9f24117c4b1fe649286651ece45b3dc2007cb8a163bf0598da48361c55d39a69163fa8fd24cf5f83655d23dca3ad961c62f356208552bb9ed529077096966d670c354e4abc9804f1746c08ca18217c32905e462e36ce3be39e772c180e86039b2783a2ec07a28fb5c55df06f4c52c9de2bcbf6955817183995497cea956ae515d2261898fa051015728e5a8aaac42dad33170d04507a33a85521abdf1cba64ecfb850458dbef0a8aea71575d060c7db3970f85a6e1e4c7abf5ae8cdb0933d71e8c94e04a25619dcee3d2261ad2ee6bf12ffa06d98a0864d87602733ec86a64521f2b18177b200cbbe117577a615d6c770988c0bad946e208e24fa074e5ab3143db5bfce0fd108e4b82d120a93ad2caffffffffffffffff",
                        16);
        final BigInteger g = new BigInteger("2");
        return new DHParameterSpec(p, g);
    }
    public void createKeys() throws NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException {

        DHParameterSpec modp15 = modp15();
        KeyPairGenerator serverKeyGen = KeyPairGenerator.getInstance("DH");
        serverKeyGen.initialize(modp15);
        KeyPair serverKeyPair = serverKeyGen.generateKeyPair();
        byte[] serverPublicKeyBytes = ((DHPublicKey)serverKeyPair.getPublic()).getY().toByteArray();

        byte[] serverPrivateBytes = ((DHPrivateKey)serverKeyPair.getPrivate()).getX().toByteArray();


        FileWriter file = new FileWriter("D:\\SN-Project\\SN-Project\\src\\main\\resources\\static\\public.txt");
        file.write(toHexString(serverPublicKeyBytes));
        file.close();

        file = new FileWriter("D:\\SN-Project\\SN-Project\\src\\main\\resources\\static\\private.txt");
        file.write(toHexString(serverPrivateBytes));
        file.close();

    }
    public String sendPDSKey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("D:\\SN-Project\\SN-Project\\src\\main\\resources\\static\\public.txt"));
        String line = reader.readLine();
        reader.close();
        return line;

    }
    public byte[] generateSecretKey(String clientPublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, InvalidKeyException {

        DHParameterSpec modp15 = modp15();

        //byte[] clientPublicKeyBytes = hexStringToByteArray(clientPublicKey);

        BigInteger clientPublicKeyInt = new BigInteger(clientPublicKey, 16);

        KeyFactory keyFactory = KeyFactory.getInstance("DH");
        DHPublicKeySpec clientPublicKeySpecs = new DHPublicKeySpec(
                clientPublicKeyInt,
                modp15.getP(),
                modp15.getG());
        DHPublicKey clientPKey = (DHPublicKey)keyFactory.generatePublic(clientPublicKeySpecs); // Public key done

        // now get server private key

        BufferedReader reader = new BufferedReader(new FileReader("D:\\SN-Project\\SN-Project\\src\\main\\resources\\static\\private.txt"));
        String line = reader.readLine();
        reader.close();

        byte[] serverPrivateKeyBytes = hexStringToByteArray(line);
        BigInteger serverPrivateInt = new BigInteger(serverPrivateKeyBytes);
        DHPrivateKeySpec serverPrivateKeySpecs = new DHPrivateKeySpec(
                serverPrivateInt,
                modp15.getP(),
                modp15.getG());

        DHPrivateKey serverPrivateKey = (DHPrivateKey)keyFactory.generatePrivate(serverPrivateKeySpecs); // server private done

        KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(serverPrivateKey);

        keyAgreement.doPhase(clientPKey, true);
        byte[] sharedSecretKey = keyAgreement.generateSecret();

        System.out.println(toHexString(sharedSecretKey));

        return sharedSecretKey;
    }

    public String decrypt(byte[] sharedSecretKey, String encryptedData, String iv, String tag) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchProviderException, InvalidParameterSpecException {

        byte[] newArray = new byte[32];
        System.arraycopy(sharedSecretKey, 0, newArray, 0, 32);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

        /*byte[] ivBytes = new byte[16];
        System.arraycopy(encryptedBytes, 0, ivBytes, 0, 16);
        System.out.println(Base64.getEncoder().encodeToString(ivBytes));
        byte[] encrypted = new byte[encryptedBytes.length - 12 - 16];
        System.arraycopy(encryptedBytes, 12, encrypted, 0, encryptedBytes.length - 12 - 16);
        System.out.println(Base64.getEncoder().encodeToString(encrypted));
        byte[] tagBytes = new byte[16];
        System.arraycopy(encryptedBytes, encryptedBytes.length - 16, tagBytes, 0, 16);
        System.out.println(Base64.getEncoder().encodeToString(tagBytes)); */
        SecretKeySpec keySpec = new SecretKeySpec(newArray, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.getDecoder().decode(iv));

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);

        byte[] decryptedData = cipher.doFinal(encryptedBytes);

        return new String(decryptedData);
    }
}
