package com.example.demo.model;


public class EncryptedPayload {

    private String encryptedData;
    private String encryptedKey;

    public EncryptedPayload(String s, String s1) {
        this.encryptedData = s;
        this.encryptedKey = s1;
    }

    // Getters and setters

    public String getEncryptedData() {
        return encryptedData;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }
}