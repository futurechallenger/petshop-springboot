package com.petshop.domain;

/**
 * Created by challenger on 24/6/2017.
 */
public class ResultInfo<T> {
  private int code;
  private String message;
  private T data;

  public ResultInfo(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public int getCode() {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }
}