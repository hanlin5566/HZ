package com.hzcf.operation.interceptor;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DESEncryption {

    public static final String UNICODE_FORMAT = "UTF8";
    public static final String DES_ENCRYPTION_SCHEME = "DES";

    private KeySpec keySpec;
    private SecretKeyFactory secretKeyFactory;
    private Cipher cipher;
    private byte[] keyAsBytes;
    private String encryptionKey;
    private String encryptionScheme;
    private SecretKey secretKey;

    public DESEncryption(String key) throws Exception {
        try {
            encryptionKey = key; // the secure key
            encryptionScheme = DES_ENCRYPTION_SCHEME;
            keyAsBytes = encryptionKey.getBytes(UNICODE_FORMAT);
            keySpec = new DESKeySpec(keyAsBytes);
            secretKeyFactory = SecretKeyFactory.getInstance(encryptionScheme);
            cipher = Cipher.getInstance(encryptionScheme);
            secretKey = secretKeyFactory.generateSecret(keySpec);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method To Encrypt The String
     * 
     * @throws EncryptException
     */
    public String encrypt(String unencryptedString) throws Exception {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = Base64.encodeBase64String(encryptedText);
        } catch (Exception e) {
            throw e;
        }
        return encryptedString;
    }

    /**
     * Method To Decrypt An Ecrypted String
     * 
     * @throws EncryptException
     */
    public String decrypt(String encryptedString) throws Exception {
        String decryptedText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText = bytes2String(plainText);
        } catch (Exception e) {
            throw e;
        }
        return decryptedText;
    }

    /**
     * Returns String From An Array Of Bytes
     */
    private static String bytes2String(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append((char) bytes[i]);
        }
        return stringBuffer.toString();
    }
}