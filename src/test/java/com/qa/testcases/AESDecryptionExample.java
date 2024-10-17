package com.qa.testcases;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESDecryptionExample {

    public static void main(String[] args) {
        // Base64-encoded encrypted data
        String encryptedData = "98encr7EPwGVW0Doxclxi9pN6q9RrF0ngkAZ4wLTmgK0f6AZYNsrlmIS3tzg5ZKZlsIzVWtEqdRtOik3K2S3heYoPy+RLnh3mJGt9Ido5QEbL8lKcKSI9ubircf3w1OJfrSSRDHFTr/RKJhPXGRNFLg/D4/YHEJnWgHy/zMOlOjcqWD/sgds4N+J2LAes4LUMG8v6GgwpLVONJHM+fMyDMzTCAEOkSEUICf/N/J2BBHlYP1DO7uLckwNXilT6enCeWBqVgotKkOoB4P8987IW2I4/MLGuGUKwUQVRUVUUF88StHGFq7GIxV8wdF2n2A795/+HaIqlp450HcDoqB5tovi1y2gljQ9BwOEBa3Q9CxlR/JVQkUWIVPYKojpYmu9gZZe8ePVQUXKAoZiT03fLjMxdBPUoxEma6ycjZSaFgx3vVDoExf8uQvvs7Nzqu8T5Kg8GTWg2PfVjPOnN/tLxt7z0vrB1ZJihjMKFo07XxKpOhgDdfvMSAjTfi5/jJu9xrX82osMsQKxOHxaDtJrRTPJEKeQcMvUAgiJw/E38pGuXhuDvsP7QVNpdoobKDnnE4tP3zA/QM2ZN/mPbHvr6150PUX8sCF5pDPyJBmIjjkSKKALlaXmLJXwogWAMyWC";

        // Replace these with your AES key and IV
        String key = "YOUR_32_BYTE_AES_KEY_HERE"; // This should be exactly 32 characters for AES-256
        String iv = "YOUR_16_BYTE_IV_HERE";       // This should be exactly 16 characters for IV

        try {
            // Check the key length
            if (key.length() != 32) {
                throw new IllegalArgumentException("AES key length should be 32 bytes (32 characters) for AES-256.");
            }
            if (iv.length() != 16) {
                throw new IllegalArgumentException("AES IV length should be 16 bytes (16 characters).");
            }

            // Decode base64 encoded encrypted data
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

            // Initialize AES key and IV
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));

            // Set up the cipher for AES decryption
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

            // Decrypt the data
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            String decryptedData = new String(decryptedBytes, "UTF-8");

            System.out.println("Decrypted Data: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}