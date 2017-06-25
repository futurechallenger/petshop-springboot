package com.petshop.utils;

public class Constants {

  public interface Code {
    int DONE = 0;
    int GENERAL_ERROR = 1; // All errors are presented by this. Other error code will be added.
  }

  public interface Message {
    String SUCCESS_MESSAGE = "done";
    String FAIL_MESSAGE = "failed";
  }
}