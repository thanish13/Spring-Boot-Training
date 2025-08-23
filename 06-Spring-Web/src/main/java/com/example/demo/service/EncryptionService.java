package com.example.demo.service;

import com.example.demo.model.EncryptedPayload;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

@Service
public class EncryptionService {

    private final KeyPair rsaKeyPair;

    public EncryptionService() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        rsaKeyPair = keyGen.generateKeyPair();
    }

    public EncryptedPayload encrypt(String plainText) throws Exception {
        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey aesKey = keyGen.generateKey();

        // Encrypt data with AES
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encryptedData = aesCipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        // Encrypt AES key with RSA
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, rsaKeyPair.getPublic());
        byte[] encryptedKey = rsaCipher.doFinal(aesKey.getEncoded());

        return new EncryptedPayload(
                Base64.getEncoder().encodeToString(encryptedData),
                Base64.getEncoder().encodeToString(encryptedKey)
        );
    }

    public String decrypt(EncryptedPayload payload) throws Exception {
        // Decrypt AES key with RSA
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.DECRYPT_MODE, rsaKeyPair.getPrivate());
        byte[] aesKeyBytes = rsaCipher.doFinal(Base64.getDecoder().decode(payload.getEncryptedKey()));
        SecretKey aesKey = new SecretKeySpec(aesKeyBytes, "AES");

        // Decrypt data with AES
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] decryptedData = aesCipher.doFinal(Base64.getDecoder().decode(payload.getEncryptedData()));

        return new String(decryptedData, StandardCharsets.UTF_8);
    }
}
