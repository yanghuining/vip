package com.example.demo.service;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class ApiMac {
    private static final String CHARSET_NAME = "UTF-8";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    public static String sign(String appKey, String data) {
        Mac mac = null;
        String hash;
        try {
            byte[] appKeyBytes = appKey.getBytes(CHARSET_NAME);
            SecretKeySpec signingKey = new SecretKeySpec(appKeyBytes, HMAC_SHA1_ALGORITHM);
            mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);
            byte[] rawHash = mac.doFinal(data.getBytes(CHARSET_NAME));
            hash = Base64.encodeBase64String(rawHash);
        } catch (Exception e) {
            throw new RuntimeException("sign Failed use HMAC-SHA1 {} ", e);
        } finally {
            mac.reset();
        }
        return hash;
    }

/*
    public static String highEndConcatString(Map<String, Object> paramterMap) {
        // 按照key升续排序，然后拼接参数
        Set<String> keySet = paramterMap.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (paramterMap.get(k) != null && paramterMap.get(k).toString().trim().length() > 0) {
                // 参数值为空，则不参与签名
                sb.append(paramterMap.get(k).toString().trim());
            }
        }
        return sb.toString();
    }

  /*  public static String getHighEndSign(String appId,String appKey,Map<String, Object> paramterMap) {
        String body = ApiMac.highEndConcatString(paramterMap);
        String signText = (appId + appKey + body).toLowerCase();
        return MD5Util.MD5(signText);
    }

    public static String signSHA256(String key, String data) {
        Mac sha256Hmac = null;
        StringBuilder sb = new StringBuilder();
        try {
            sha256Hmac = Mac.getInstance(HMAC_SHA256_ALGORITHM);

            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(CHARSET_NAME), HMAC_SHA256_ALGORITHM);
            sha256Hmac.init(secretKey);
            byte[] array = sha256Hmac.doFinal(data.getBytes(CHARSET_NAME));
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
        } catch (Exception e) {
            throw new RuntimeException("sign Failed use HMAC-SHA256 {} ", e);
        } finally {
            sha256Hmac.reset();
        }
        return sb.toString().toUpperCase();
    }
    */

}
