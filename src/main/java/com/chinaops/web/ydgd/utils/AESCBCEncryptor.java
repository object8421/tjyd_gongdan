/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
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
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * AES加密器，也可以做解密用
 * @author Harley Ren  
 */
public class AESCBCEncryptor {
    // ========================== Attributes ============================
    /** 密钥的算法名 */
    //public static final String AES_ALGORITHM = "AES";
    public static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================
    public static SecretKeySpec generateKey() throws NoSuchAlgorithmException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        Random random = new Random();
        byte[] bytes = new byte[128];
        random.nextBytes(bytes);
        kgen.init(128, new SecureRandom(bytes));
        SecretKey secretKey = kgen.generateKey();        
        byte[] enCodeFormat = secretKey.getEncoded();
        
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        return key;
    }

    public static SecretKeySpec generateKey(byte[] encodedKey) throws NoSuchAlgorithmException {
        return new SecretKeySpec(encodedKey, AES_ALGORITHM);
    }

    public static byte[] encrypt(byte[] clearData, String key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        
//        byte[] keyBytes = key.getBytes();
        byte[] keyBytes = Base64.decodeBase64(key);
        byte[] buf = new byte[16];

        for (int i = 0; i < keyBytes.length && i < buf.length; i++) {
            buf[i] = keyBytes[i];
        }

        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(buf);
        
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        return cipher.doFinal(clearData);
        
    }

    public static byte[] decrypt(byte[] cipherData, String key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
       
//        byte[] keyBytes = key.getBytes();
        byte[] keyBytes = Base64.decodeBase64(key);
        byte[] buf = new byte[16];

        for (int i = 0; i < keyBytes.length && i < buf.length; i++) {
            buf[i] = keyBytes[i];
        }

        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(buf);
        
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        return cipher.doFinal(cipherData);
    }

    // ==================== Private methods =====================

    // ========================== main method ===========================
    public static void main(String[] args) {
        String key = "LavophhOHJUjaahmHI9ZAA==";
        String encryptedStr = "7sWFmIVRWowcJuXjCpajqyJDFKEj5WkZlLayCcyD7y8=";        
        
        try {
            byte[] decryptData = AESCBCEncryptor.decrypt(Base64.decodeBase64(encryptedStr), key);
            String ssss = new String(decryptData, "UTF-8");
            System.out.println("解密后: " + ssss);
        } catch (InvalidKeyException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
       
        
        
        
        
    }
}
