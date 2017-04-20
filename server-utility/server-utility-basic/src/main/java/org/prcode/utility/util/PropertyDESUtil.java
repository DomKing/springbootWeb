package org.prcode.utility.util;

import org.apache.commons.codec.binary.Base64;
import org.prcode.utility.basic.CharsetConstant;
import org.prcode.utility.util.exception.DESException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @ClassName: PropertyDESUtil
 * @Date: 2017-03-24 14:28
 * @Auther: kangduo
 * @Description: (DES实现可逆加密类文件,用于对配置文件中密码进行加密解密)
 */
public class PropertyDESUtil {

    private static final byte[] RAW_KEY_DATA = "12a34d56!@3_A=".getBytes(CharsetConstant.UTF_8);
    private static final String DES = "DES";
    private static DESKeySpec DKS = null;
    private static SecretKey SECRET_KEY = null;
    private static Cipher CIPHER = null;

    private static void init() throws DESException {
        try {
            init(RAW_KEY_DATA);
        } catch (Exception e) {
            throw new DESException("use the default key initial DES exception.", e);
        }
    }

    private static void init(byte[] byteData) throws DESException {
        try {
            DKS = new DESKeySpec(byteData);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SECRET_KEY = keyFactory.generateSecret(DKS);
            CIPHER = Cipher.getInstance(DES);
        } catch (Exception e) {
            throw new DESException("use the parameter key initial DES exception.", e);
        }
    }

    /**
     * @Title: encrypt
     * @Description: (对原始密码进行加密, 返回加密后的密文)
     * @param rawPass 原始密码
     * @return 加密后的密码
     * @throws DESException
     */
    public static String encrypt(String rawPass) throws DESException {
        try {
            init();
            byte[] encryptedData = generationEncryptedData(rawPass);
            return Base64.encodeBase64String(encryptedData);
        } catch (Exception e) {
            throw new DESException("DES use default slat encrypt exception", e);
        }
    }

    /**
     * @Title: encrypt
     * @Description: (对原始密码进行加密, 返回加密后的密文)
     * @param rawPass 原始密码
     * @param byteData 盐值
     * @return 加密后的密码
     * @throws DESException
     */
    public static String encrypt(String rawPass, byte[] byteData) throws DESException {
        try {
            init(byteData);
            byte[] encryptedData = generationEncryptedData(rawPass);
            return Base64.encodeBase64String(encryptedData);
        } catch (Exception e) {
            throw new DESException("DES use user slat encrypt exception", e);
        }
    }

    private static byte[] generationEncryptedData(String rawPass) throws Exception {
        if (null == DKS || null == SECRET_KEY || null == CIPHER) {
            return null;
        }

        SecureRandom secureRandom = new SecureRandom();
        CIPHER.init(Cipher.ENCRYPT_MODE, SECRET_KEY, secureRandom);
        return CIPHER.doFinal(rawPass.getBytes(CharsetConstant.UTF_8));
    }

    /**
     *
     * @Title: decrypt
     * @Description: (对无盐值的密码进行解密, 返回解密后的原文)
     * @param ciphertext 原文
     * @return 解密后的字符
     * @throws DESException
     */
    public static String decrypt(String ciphertext) throws DESException {
        try {
            init();
            byte[] generationDecryptData = generationDecryptData(ciphertext);
            if (generationDecryptData == null) {
                return null;
            }
            return new String(generationDecryptData, CharsetConstant.UTF_8);
        } catch (Exception e) {
            throw new DESException("DES use default slat decrypt exception", e);
        }
    }

    /**
     *
     * @Title: decrypt
     * @Description: (对带盐值的密码进行解密, 返回解密后的原文)
     * @param ciphertext 原文
     * @param byteData 盐值
     * @return 解密后的字符
     * @throws DESException
     */
    public static String decrypt(String ciphertext, byte[] byteData) throws DESException {
        try {
            init(byteData);
            byte[] generationDecryptData = generationDecryptData(ciphertext);
            if (generationDecryptData == null) {
                return null;
            }
            return new String(generationDecryptData, CharsetConstant.UTF_8);
        } catch (Exception e) {
            throw new DESException("DES use user slat decrypt exception", e);
        }
    }

    private static byte[] generationDecryptData(String ciphertext) throws Exception {
        if (null == DKS || null == SECRET_KEY || null == CIPHER) {
            return null;
        }

        SecureRandom secureRandom = new SecureRandom();
        CIPHER.init(Cipher.DECRYPT_MODE, SECRET_KEY, secureRandom);
        byte[] ciphertextByte = ciphertext.getBytes(CharsetConstant.UTF_8);
        ciphertextByte = Base64.decodeBase64(ciphertextByte);
        return CIPHER.doFinal(ciphertextByte);
    }

}
