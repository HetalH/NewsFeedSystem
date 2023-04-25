package com.scaler.lld.helper;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class PasswordEncryptionHelper {
    private static final int iterations = 10000;
    private static final int keylength = 256;
   public static boolean verifyUserPassword(String providedPassword,
                                             String securedPassword) {
        String newSecurePassword = generateSecurePassword(providedPassword);
        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }

    public static String generateSecurePassword(String password) {
        byte[] securePassword = hash(password.toCharArray(), "abcd".getBytes());
        return Base64.getEncoder().encodeToString(securePassword);
    }

    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static void main(String[] args) {
        System.out.println(generateSecurePassword("1Destiny"));
        System.out.println(generateSecurePassword("1Destiny"));
    }
}
