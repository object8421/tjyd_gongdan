/*
 * $Id$
 * 
 * All Rights Reserved 2012 China OPS Information Technology Co.,Ltd.
 */
package com.chinaops.web.ydgd.utils;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * RSA加密器，也可以做解密用
 * @author Harley Ren  
 */
public class RSAEncryptor {
    // ========================== Attributes ============================
    /** 密钥的算法名 */
    public static final String KEY_ALGORITHM       = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    // ========================= Constructors ===========================

    // ======================= Getters & Setters ========================

    // ======================== Public methods ==========================

    /**
     * 用私钥对数据进行加密
     * @param clearData 未加密的数据
     * @param key 私钥，此私钥是Base64编码过的。
     * @return 加密后的byte数组
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] clearData, String key) throws Exception {

        //取私钥匙对象  
        PrivateKey privateKey = generatetPrivateKey(key);

        // 对数据加密  
        Cipher cipher = Cipher.getInstance(KeyFactory.getInstance(KEY_ALGORITHM).getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(clearData);
    }

    /**
     * 用私钥对数据进行解密
     * @param cipherDate 加密的数据
     * @param key 私钥，此私钥是Base64编码过的。
     * @return 解密后的byte数组
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] cipherData, String key) throws Exception {

        //取私钥匙对象  
        PrivateKey privateKey = generatetPrivateKey(key);

        //对数据解密
        Cipher cipher = Cipher.getInstance(KeyFactory.getInstance(KEY_ALGORITHM).getAlgorithm());

        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(cipherData);
    }

    /**
     * 用公钥对数据进行加密
     * @param clearData 未加密的数据
     * @param key 公钥，此公钥是Base64编码过的。
     * @return 加密后的byte数组
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] clearData, String key) throws Exception {
        //取公钥匙对象  
        PublicKey publicKey = generatePublicKey(key);

        //对数据加密  
        Cipher cipher = Cipher.getInstance(KeyFactory.getInstance(KEY_ALGORITHM).getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(clearData);
    }

    /**
     * 用公钥对数据进行解密
     * @param cipherDate 加密的数据
     * @param key 公钥，此公钥是Base64编码过的。
     * @return 解密后的byte数组
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] cipherData, String key) throws Exception {

        //取公钥匙对象  
        PublicKey publicKey = generatePublicKey(key);

        // 对数据解密  
        Cipher cipher = Cipher.getInstance(KeyFactory.getInstance(KEY_ALGORITHM).getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(cipherData);
    }

    /** 
     * 用私钥对信息生成数字签名
     * Note:RSA只有私钥才能对消息进行签名，无法用公钥做签名。验证签名只能用公钥，不能用私钥。
     *  
     * @param data 加密数据 
     * @param privateKey 私钥 
     *  
     * @return 
     * @throws Exception 
     */
    public static String signByPrivateKey(byte[] data, String privateKey) throws Exception {
        PrivateKey priKey = generatetPrivateKey(privateKey);

        // 用私钥对信息生成数字签名  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);

        return Base64.encodeBase64String(signature.sign());
    }

    /** 
     * 用公钥校验数字签名
     * Note:RSA只有私钥才能对消息进行签名，无法用公钥做签名。验证签名只能用公钥，不能用私钥。
     * @param data 加密数据 
     * @param publicKey 公钥 
     * @param sign 数字签名 
     *  
     * @return 校验成功返回true 失败返回false 
     * @throws Exception 
     *  
     */
    public static boolean verifyByPublicKey(byte[] data, String publicKey, String sign)
            throws Exception {

        //取公钥匙对象  
        PublicKey pubKey = generatePublicKey(publicKey);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);

        // 验证签名是否正常  
        return signature.verify(Base64.decodeBase64(sign));
    }

    // ==================== Private utility methods =====================
    /**
     * 把Base64编码后的私钥解码，并生成PrivateKey对象。
     * @param privateKey Base64编码后的私钥
     * @return PrivateKey对象
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static PrivateKey generatetPrivateKey(String privateKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        //解密由base64编码的私钥  
        byte[] keyBytes = Base64.decodeBase64(privateKey);

        //构造PKCS8EncodedKeySpec对象  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        //KEY_ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取私钥匙对象  
        return keyFactory.generatePrivate(pkcs8KeySpec);
    }

    /**
     * 把Base64编码后的公钥解码，并生成PublicKey对象。
     * @param publicKey Base64编码后的公钥
     * @return PublicKey 对象
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static PublicKey generatePublicKey(String publicKey) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        //解密由base64编码的公钥  
        byte[] keyBytes = Base64.decodeBase64(publicKey);

        //构造X509EncodedKeySpec对象  
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        //KEY_ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        //取公钥匙对象  
        return keyFactory.generatePublic(keySpec);
    }
    // ========================== main method ===========================
}
