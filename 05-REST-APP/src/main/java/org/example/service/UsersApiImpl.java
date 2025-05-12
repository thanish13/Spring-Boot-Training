package org.example.service;

import jakarta.ws.rs.core.Response;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.api.UsersApi;
import org.example.model.Body;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
public class UsersApiImpl implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiImpl.class);

    Generator generator;
    Cipher cipher;


    public UsersApiImpl() throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.generator = new Generator();
        this.cipher = Cipher.getInstance("RSA");
    }

    public static class Generator {

        KeyPairGenerator generator;

        public Generator() throws NoSuchAlgorithmException {
            this.generator = KeyPairGenerator.getInstance("RSA");
        }

        public KeyPair pair(){
            generator.initialize(2048);
            return generator.generateKeyPair();
        }
    }

    @Override
    public Response usersEncryptGet() {
        try{
            String secretMessage = "message";

            cipher.init(Cipher.ENCRYPT_MODE, generator.pair().getPublic());

            byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = cipher.doFinal(secretMessageBytes);

            String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
            String key = Base64.getEncoder().encodeToString(generator.pair().getPrivate().getEncoded());

            EncryptedMessage encryptedMessage = new EncryptedMessage(encodedMessage, key);

            return Response.status(200).entity(encryptedMessage).build();
        }
        catch (BadPaddingException |
               InvalidKeyException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Response usersDecryptGet(Body body) {

        try{

            KeyFactory kf = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(body.getKey())));

            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            log.info("{}",Base64.getEncoder().encodeToString(privateKey.getEncoded()));

            byte[] decodedBytes = Base64.getDecoder().decode(body.getMessage());
            byte[] decryptedMessageBytes = cipher.doFinal(decodedBytes);

            String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

            return Response.status(200).entity(decryptedMessage).build();
        }
        catch (NoSuchAlgorithmException | BadPaddingException | InvalidKeyException |
               IllegalBlockSizeException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    @Getter
    @Setter
    @Builder
    public static class EncryptedMessage{
        String message;
        String key;

        public EncryptedMessage(String message, String key){
            this.message = message;
            this.key = key;
        }
    }
}
