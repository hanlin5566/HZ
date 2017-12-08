package com.hzcf.operation.interceptor;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Create by hanlin on 2017年12月7日
 **/
public class TokenEncryption {

    private static final String FIELD_SEPARATOR = "~~~";
    private final String[] keys;

    public TokenEncryption(String... keys) {
        this.keys = keys;
    }

    public String encrypt(String unencrypted) throws Exception {
        String sig = hex(unencrypted);
        String encrypted = sig + FIELD_SEPARATOR + unencrypted;

        for (int i = 0; i < this.keys.length; i++) {
            encrypted = new DESEncryption(this.keys[i]).encrypt(encrypted);
        }
        try {
            return URLEncoder.encode(encrypted, DESEncryption.UNICODE_FORMAT);
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
    }

    private String hex(String raw) {
        return DigestUtils.md5Hex(raw);
    }

    public String decrypt(final String encrypted) throws Exception {
        if (encrypted == null) {
            throw new NullPointerException("encrypted is null");
        }

        String decrypted;
        try {
            decrypted = URLDecoder.decode(encrypted, DESEncryption.UNICODE_FORMAT);
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
        for (int i = this.keys.length - 1; i >= 0; i--) {
            decrypted = new DESEncryption(this.keys[i]).decrypt(decrypted);
        }

        int index = decrypted.indexOf(FIELD_SEPARATOR);
        if (index > 0) {
            String sig = decrypted.substring(0, index);
            String orig = decrypted.substring(index + FIELD_SEPARATOR.length());
            if (sig.equals(hex(orig))) {
                return orig;
            }
        }

        throw new RuntimeException("Invalid token: " + encrypted);
    }
}
