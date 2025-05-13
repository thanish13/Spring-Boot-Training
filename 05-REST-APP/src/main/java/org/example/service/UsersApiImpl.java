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
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class UsersApiImpl implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiImpl.class);

    Generator generator;
    Cipher cipher;

    public UsersApiImpl() throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.generator = new Generator();
        this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    }

    public static class Generator {

        KeyFactory keyFactory;

        public Generator() throws NoSuchAlgorithmException {

            this.keyFactory = KeyFactory.getInstance("RSA");

        }

        public PublicKey getPublicKey(String key) throws InvalidKeySpecException {
            return keyFactory.generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(key)));
        }

        public PrivateKey getPrivateKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key)));
        }

    }

    @Override
    public Response usersEncryptGet() {
        try{
            String secretMessage = "message";

            cipher.init(Cipher.ENCRYPT_MODE, generator.getPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArPROiNu9n9QRlkYRO3gJ\n" +
                    "k6ddiohKMRnGC83mHDxqkf7fYW2Yi+bvp/JPgUCaqE5RMAIAasCtHTnqYQzSnNOh\n" +
                    "mPvuJcr8FfLBBNq5AY8G+1hzeDbUQSYMjWquBXiBneZ6uRRTfYA+PewCtL0ql0x2\n" +
                    "tvr8/fbuZNzFLVyJ0HfAdCVr6DrfNq4pp+ZTOqSQ0q9D7KQON8j6BOQaCv5kKofE\n" +
                    "60PJ+AhEMvWcofwQsHqfNBqtjU5A0jaXT8Mu0qKU6LwJalQ9kERxm0fl7oV5Dr70\n" +
                    "pg5YExlGPom7LWei1MyMDSW93iPh/zWI/kPXJAQ7KkCTbHxvbuD39k4v3bpDfQqC\n" +
                    "vwIDAQAB"));

            byte[] secretMessageBytes = secretMessage.getBytes();
            byte[] encryptedMessageBytes = cipher.doFinal(secretMessageBytes);

            String encodedMessage = Base64.getEncoder().withoutPadding().encodeToString(encryptedMessageBytes);

            EncryptedMessage encryptedMessage = new EncryptedMessage(encodedMessage, "");

            return Response.status(200).entity(encryptedMessage).build();
        }
        catch (BadPaddingException | InvalidKeyException | IllegalBlockSizeException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Response usersDecryptGet(Body body) {

        try{

            cipher.init(Cipher.DECRYPT_MODE, generator.getPrivateKey("MIIEpQIBAAKCAQEArPROiNu9n9QRlkYRO3gJk6ddiohKMRnGC83mHDxqkf7fYW2Y\n" +
                    "i+bvp/JPgUCaqE5RMAIAasCtHTnqYQzSnNOhmPvuJcr8FfLBBNq5AY8G+1hzeDbU\n" +
                    "QSYMjWquBXiBneZ6uRRTfYA+PewCtL0ql0x2tvr8/fbuZNzFLVyJ0HfAdCVr6Drf\n" +
                    "Nq4pp+ZTOqSQ0q9D7KQON8j6BOQaCv5kKofE60PJ+AhEMvWcofwQsHqfNBqtjU5A\n" +
                    "0jaXT8Mu0qKU6LwJalQ9kERxm0fl7oV5Dr70pg5YExlGPom7LWei1MyMDSW93iPh\n" +
                    "/zWI/kPXJAQ7KkCTbHxvbuD39k4v3bpDfQqCvwIDAQABAoIBABO6DdcYUSmQs6zT\n" +
                    "MxX4XAdGWKn7X5L4IJmqE2v3DCS40Fu5d2PFpGIghib06m7199ak8805SsWBnJUT\n" +
                    "NFaE4PKlEYWoAFa0iIV4OQ/Pc3lpnkoA3vbLUzUyDMU8+HO9HRRNGDTBUtgXOjvJ\n" +
                    "M7lsFEJMoFyLNKe2cpr46hMoBYB5r/rc/ipZX5cc5Wf8NVNZiIoyT3BR8QwIul+g\n" +
                    "ZTHhPfU9GzV26mcTI89n1R+o2F5eXe1C8r2PqQVE1lLbb3WX17OwHdq1sX08D15i\n" +
                    "HsT+LAswuu7Pl9RlDGoOAdicwShor0hcEwbPphe0aSCi30xZ4rVAqPOvn80UA2aB\n" +
                    "1l/KUuECgYEA57RA9rDR3ROG3eiOxDnZwb2QryeIT7tCnlkRLfvXP17Fko3PZ7tk\n" +
                    "/tb67AzaExW3k0juRTSP72b9SA9LxAQBLCabawRdCRtoz7oGWILQ4CkA9ibG3KXE\n" +
                    "hyNhreKhdn2bnDOheuh9yHi/D4ZwgQKq/IqsuuNxNDViA9zoUvzXtbECgYEAvxcA\n" +
                    "9ljgCMC9sInjNHwa7pYhqj/X9UGXIGEKvTX4I4QZpodLQbP1equuJLDZBT6oRb1o\n" +
                    "6+D3xK35mEc8BgtrVN9zlvY5QL2Z0VF0BpVIFMjH/i0IG5TWBnyITmETSkMSAHqM\n" +
                    "+NDUa6ToCOPAC7C0eoU6T4l2+WU20KW2rrleK28CgYEAx8LaN1UeuhE5t1vmqjqO\n" +
                    "CMCcWsYkeUkjGE4Fx7VWUCYvBDkK1Y30dtl1n8k8wjN4/5xjAHtelLIgL94wHiCt\n" +
                    "uhjW6Z7rbwyYgm8JRYoS9w+i6pVn4ZdxJmlUr4uyVOvaGwNQdxy2RP4FCyeHG1Ln\n" +
                    "g68zWDT6xl430MjF67ZdayECgYEAqRioJ1caWWSF95TtU+KGyp5cCBYa+tMh8uss\n" +
                    "36bEgFlDgZOzyt5+2iDWJ22/fd6mdaBZGnKnjooNlu1idk7gmehqlyooG9wsI4ia\n" +
                    "zcCIWqwaHhinVhDtHCxTSlipA0w6v+WynfPeJat2EXfI2A90hf8jTILun18rlJMw\n" +
                    "B4nNhU0CgYEArjivThvql4PbyvEHUr5We/gqfB/Vo2sFWEHoFIBw6vF7JC2lFaJy\n" +
                    "3AVPzrkQbk7TaRwIXpCWegwa71g4WL/6ml9A34OUb4SvflMPbFclKFkct5INZW3F\n" +
                    "IthahE8RHESmjCaUz8uJz+0Ss9nd06QyyQ7rtIFsCrhqGl8v5ULaPOg="));

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
