package com.devfuns.model;

import java.util.Map;

public class TokenModel {
    private String sub;
    private long exp;
    private Map header;
    private Map body;
    private String tokenException; // token异常信息
    private String signature;
    private String exceptionMsg;



    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public String getTokenException() {
        return tokenException;
    }

    public void setTokenException(String tokenException) {
        this.tokenException = tokenException;
    }

    public Map getHeader() {
        return header;
    }

    public void setHeader(Map header) {
        this.header = header;
    }

    public Map getBody() {
        return body;
    }

    public void setBody(Map body) {
        this.body = body;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "sub='" + sub + '\'' +
                ", exp=" + exp +
                ", header=" + header +
                ", body=" + body +
                ", tokenException='" + tokenException + '\'' +
                ", signature='" + signature + '\'' +
                ", exceptionMsg='" + exceptionMsg + '\'' +
                '}';
    }
}
