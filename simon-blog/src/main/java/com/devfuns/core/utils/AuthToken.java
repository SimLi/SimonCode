package com.devfuns.core.utils;

import com.devfuns.model.TokenModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.*;

public class AuthToken {

    /**
     * 生成的token，没有失效时间，即永久有效
     * */
    public static final String PERMANENT = "0"; // 永久有效

    /**
     * 生成的token，拥有有效时间
     * */
    public static final String TRANSIENCE = "1";// 暂时有效

    public static final Long DEFAULT_EXPIRATION = 1800L;

    private static final String DEFAULT_SECRET = "simon_blog";


    public static final String TOKEN_EXCEPTION_EXP = "-1"; // Token过期异常
    public static final String TOKEN_EXCEPTION_DEFAULT = "-100"; // token解析异常

    private static AuthToken authToken;

    @Autowired
    Environment env;

    @Autowired
    ObjectMapper objectMapper;



    /**
     * 生成jwt的token认证，返回token
     * code 用来生成token的编码
     * type 生成的token的有效性，0 永久有限，1 根据系统配置，生成一段时间内有效的token
     * */
    public String generateToken(String code,String expType) {
        if (env == null) {
            env = SpringContextUtil.getBean(Environment.class);
            System.out.println(env.getProperty("jwt.expiration"));
            System.out.println(env.getProperty("jwt.secret"));
        }
        Map map = new HashMap();
        map.put("code",code);
        if (PERMANENT.equals(expType)) { // 生成永久性token，及有效时间为空
            String token = Jwts.builder().setClaims(map)
                    .signWith(SignatureAlgorithm.HS256,DEFAULT_SECRET).compact();
            return token;
        } else if (TRANSIENCE.equals(expType)){

            String token = Jwts.builder().setClaims(map)
                    .setExpiration(Date.from(Instant.now().plusSeconds(DEFAULT_EXPIRATION)))
                    .signWith(SignatureAlgorithm.HS256,DEFAULT_SECRET).compact();
            return token;
        }
        return "";
    }

    public TokenModel parserToken(String token) {
        TokenModel tokenModel = null;
        try {
            if (objectMapper == null) {
                objectMapper = SpringContextUtil.getBean("objectMapper");
            }
            if (env == null) {
                env = SpringContextUtil.getBean(Environment.class);
            }
            String tokenInfo = objectMapper.writeValueAsString(Jwts.parser().setSigningKey(DEFAULT_SECRET).
                    parseClaimsJws(token));
            tokenModel = objectMapper.readValue(tokenInfo, TokenModel.class);

        } catch (Exception e) {
            // e.printStackTrace();
            if (e instanceof ExpiredJwtException) { // token过期
                tokenModel = new TokenModel();
                tokenModel.setTokenException(AuthToken.TOKEN_EXCEPTION_EXP);
            } else {
                tokenModel = new TokenModel();
                tokenModel.setTokenException(AuthToken.TOKEN_EXCEPTION_DEFAULT);
                tokenModel.setExceptionMsg(e.getMessage());
            }
        }

        return tokenModel;

    }

    /**
     * 生成jwt的token认证，返回token
     * code 用来生成token的编码
     * type 生成的token的有效性，0 永久有限，1 根据系统配置，生成一段时间内有效的token
     * */
    public  static String getAuthTokenCode(String code,String type) {
        if (authToken == null) {
            authToken = new AuthToken();
        }
        String token = authToken.generateToken(code,type);
        return token;

    }

    public static TokenModel parserTokenToString(String token) {
        if (authToken == null) {
            authToken = new AuthToken();
        }
        return authToken.parserToken(token);

    }

    public static void main(String[] args) {
        String token = null;
        try {
            Map map = new HashMap();
            map.put("code","Simon");

            Map heard = new HashMap();
            heard.put("header","http");
            heard.put("key","Simon");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            token = Jwts.builder().setClaims(map).setSubject("Simon")
                    .signWith(SignatureAlgorithm.HS256, "plan").compact();
            System.out.println("token == " + token);
            System.out.println(map);
            System.out.println(Jwts.parser().setSigningKey("plan").parseClaimsJws(token).getSignature());
            System.out.println(Jwts.parser().setSigningKey("plan").parseClaimsJws(token).getBody());
            System.out.println(Jwts.parser().setSigningKey("plan").parse(token));
            String tokenInfo = objectMapper.writeValueAsString(Jwts.parser().setSigningKey("plan").
                    parseClaimsJws(token));
            System.out.println("tokenInfo == " + tokenInfo);
            TokenModel tokenModel = objectMapper.readValue(tokenInfo, TokenModel.class);

            System.out.println(tokenModel);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
