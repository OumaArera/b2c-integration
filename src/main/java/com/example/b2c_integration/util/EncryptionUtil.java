package com.example.b2c_integration.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    private static final String SECRET_KEY = "my_secret_key_123"; 

    // Initialize Cipher for AES encryption
    private static Cipher initCipher(int mode) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(mode, keySpec);
        return cipher;
    }

    public static String encrypt(String data) {
        try {
            Cipher cipher = initCipher(Cipher.ENCRYPT_MODE);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during encryption", e);
        }
    }

    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = initCipher(Cipher.DECRYPT_MODE);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during decryption", e);
        }
    }

    // Utility method to generate a new AES key
    public static String generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // AES-128
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    public static void main(String[] args) {
        try {
            String originalText = "Hello, World!";
            String encryptedText = encrypt(originalText);
            String decryptedText = decrypt(encryptedText);

            System.out.println("Original Text: " + originalText);
            System.out.println("Encrypted Text: " + encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
