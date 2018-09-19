package com.devfuns.core.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;


/**
 * Created by sim on 2018/8/29.
 * 密码加密算法
 */
public class JavaMDUtils {
    private final static Logger logger = LoggerFactory.getLogger(JavaMDUtils.class);

    /**
     * MD5加密
     * */
    public static String commonsCodecMD5(String sec) {
        String md5Str = null;
        try {
            md5Str = DigestUtils.md5DigestAsHex(sec.getBytes());

            return md5Str;
        } catch (Exception e) {
            logger.info("密码加密失败" + sec);
        }
        return md5Str;
    }

    public static void main(String[] args) {
        System.out.println(commonsCodecMD5("abcd1234"));
    }

}
