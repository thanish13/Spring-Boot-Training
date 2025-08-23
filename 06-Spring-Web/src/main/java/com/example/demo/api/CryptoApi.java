package com.example.demo.api;

import com.example.demo.model.EncryptedPayload;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/crypto")
public interface CryptoApi {

    @PostMapping("/encrypt")
    public EncryptedPayload encrypt(@RequestHeader String plainText) throws Exception;

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody EncryptedPayload encryptedPayload) throws Exception;


}
