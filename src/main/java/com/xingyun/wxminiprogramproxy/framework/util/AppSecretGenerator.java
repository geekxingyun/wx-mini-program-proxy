package com.xingyun.wxminiprogramproxy.framework.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/***
 * @author qingfeng.zhao
 * @date 2023/5/13
 * @apiNote
 */
@Slf4j
public class AppSecretGenerator {

    public static String generateAppSecret(String appKey) {
        try {
            // Generate a random UUID
            String randomUUID = UUID.randomUUID().toString();

            // Concatenate the appKey and UUID
            String text = appKey + randomUUID;

            // Get an instance of the SHA-256 message digest algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Generate a byte array from the concatenated string
            byte[] hash = digest.digest(text.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Return the first 32 characters of the hexadecimal string
            return hexString.toString().substring(0, 32);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AppSecretGenerator(){

    }
}
