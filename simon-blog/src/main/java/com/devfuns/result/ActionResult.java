package com.devfuns.result;

/**
 * Created by sim on 2018/8/29.
 */
public class ActionResult {
    private Integer code;
    private String message;
    private Object data;
    private String token;

    public ActionResult() {
        this.code = ActionResultEnum.COMPLETE;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
