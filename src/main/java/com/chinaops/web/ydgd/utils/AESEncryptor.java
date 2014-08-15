/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密器，也可以做解密用
 * @author Harley Ren  
 */
public class AESEncryptor {
    // ========================== Attributes ============================
    /** 密钥的算法名 */
    public static final String AES_ALGORITHM = "AES";

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================
    public static SecretKeySpec generateKey() throws NoSuchAlgorithmException {
        KeyGenerator kgen = KeyGenerator.getInstance(AES_ALGORITHM);
        Random random = new Random();
        byte[] bytes = new byte[128];
        random.nextBytes(bytes);
        kgen.init(128, new SecureRandom(bytes));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES_ALGORITHM);
        return key;
    }
    
    public static SecretKeySpec generateKey(byte[] encodedKey) throws NoSuchAlgorithmException {
        return new SecretKeySpec(encodedKey, AES_ALGORITHM);
    }

    public static byte[] encrypt(byte[] clearData, SecretKeySpec key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(clearData);
    }

    public static byte[] decrypt(byte[] cipherData, SecretKeySpec key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherData);
    }

    // ==================== Private methods =====================

    // ========================== main method ===========================
}
