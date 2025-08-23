package com.example.demo.api.impl;

import com.example.demo.api.CryptoApi;
import com.example.demo.model.EncryptedPayload;
import com.example.demo.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@RestController
public class CryptoApiImpl implements CryptoApi {

    @Autowired
    EncryptionService encryptionService;

    @Override
    public EncryptedPayload encrypt(String plainText) throws Exception {
        return encryptionService.encrypt(plainText);
    }

    @Override
    public String decrypt(EncryptedPayload encryptedPayload) throws Exception {
      return encryptionService.decrypt(encryptedPayload);

    }
}
