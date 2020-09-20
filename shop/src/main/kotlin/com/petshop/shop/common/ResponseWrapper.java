package com.petshop.shop.common;

import java.io.Serializable;

/**
 * Created by 赵权 on 16/10/28.
 */
public class ResponseWrapper implements Serializable {
    private String code;
    private String message;
    private Object data;

    public ResponseWrapper() {
    }

    public static ResponseWrapper getResponseJson(String code, String message, Object data) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(code);
        responseWrapper.setMessage(message);
        if (data == null) {
            responseWrapper.setData("{}");
        } else {
            responseWrapper.setData(data);
        }
        return responseWrapper;
    }

    public static ResponseWrapper getBlankResponseJson(String code, String message) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(code);
        responseWrapper.setMessage(message);
        responseWrapper.setData("{}");
        return responseWrapper;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
}

