package com.example.yg191.encryptdemo.utils;

import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yg191 on 2020/5/14.
 */

public class Encryption {

    public static String getMD5(File f){
        BigInteger bi = null;
        byte[] buffer = new byte[8192];
        int len = 0;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream fis = new FileInputStream(f);
            while((len = fis.read(buffer)) != -1){
                md.update(buffer, 0, len);
            }
            fis.close();
            byte[] b = md.digest();
            bi = new BigInteger(1, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(bi != null)
            return bi.toString(16);
        else
            return "";
    }

    public static String md5(String str){
        if(TextUtils.isEmpty(str)){
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            String result = "";
            for(byte b : bytes){
                String temp = Integer.toHexString(b & 0xff);
                if(temp.length() == 1){
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
