package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.api.UsersApi;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class UsersApiImpl implements UsersApi {

    @Override
    public Response usersEncryptGet() {
        try{
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();
            try (FileOutputStream fos = new FileOutputStream("public.key")) {
                fos.write(publicKey.getEncoded());
            }

            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            try (FileOutputStream fos = new FileOutputStream("private.key")) {
                fos.write(pkcs8EncodedKeySpec.getEncoded());
            }

            File publicKeyFile = new File("public.key");
            byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            keyFactory.generatePublic(publicKeySpec);

            PublicKey pubKey = keyFactory.generatePublic(publicKeySpec);

            String secretMessage = "Baeldung secret message";

            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);

            byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

            byte[] encodedMessage = Base64.getEncoder().encode(encryptedMessageBytes);

            File privateKeyFile = new File("private.key");
            byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());

            KeyFactory privateKeyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            privateKeyFactory.generatePrivate(privateKeySpec);

            PrivateKey priKey = privateKeyFactory.generatePrivate(privateKeySpec);

            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, priKey);

            byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
            String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

            return Response.status(200).entity(decryptedMessage).build();
        }
        catch (NoSuchAlgorithmException | BadPaddingException | IOException | InvalidKeySpecException |
               NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Response usersDecryptGet(String body) {

        try {
            File privateKeyFile = new File("private.key");
            byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            keyFactory.generatePrivate(privateKeySpec);

            PrivateKey key = keyFactory.generatePrivate(privateKeySpec);

            String secretMessage = "Baeldung secret message";

            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
            String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

            return Response.status(200).entity(decryptedMessage).build();
        }
        catch (NoSuchAlgorithmException | BadPaddingException | IOException | InvalidKeySpecException |
                 NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }
}
