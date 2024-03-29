package com.sftxy.wechatmp.irs.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ValidationUtil {

    public static boolean validate(String signature, String timestamp, String nonce, String token) {
        String encrypted = ValidationUtil.generateSignature(timestamp, nonce, token);
        return signature.equalsIgnoreCase(encrypted);
    }

    private static String encryptWithSha1(String input) {
        MessageDigest msgDigest = null;
        String str = null;
        try {
            msgDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
        }

        if (null != msgDigest) {
            byte[] bt = input.getBytes();
            msgDigest.update(bt);
            str = ValidationUtil.byte2hex(msgDigest.digest());
        }

        return str;
    }

    private final static String byte2hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (byte b : bytes) {
            tmp = Integer.toHexString(b & 0xFF);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static String generateSignature(String timestamp, String nonce, String token) {
        String[] toBeSort = new String[] { token, timestamp, nonce };
        Arrays.sort(toBeSort);
        String sorted = null;
        StringBuffer bf = new StringBuffer();
        for (String str : toBeSort) {
            bf.append(str);
        }
        sorted = bf.toString();

        String encrypted = ValidationUtil.encryptWithSha1(sorted);

        return encrypted;
    }

}
