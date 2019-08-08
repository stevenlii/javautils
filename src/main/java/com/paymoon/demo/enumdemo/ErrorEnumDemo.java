package com.paymoon.demo.enumdemo;
public enum ErrorEnumDemo {
  DEFAULT(0, "success."),
  DATABASE(1, "A database error has occured."),
  DUPLICATE_USER(2, "This user already exists.");

  private final int code;
  private final String description;

  private ErrorEnumDemo(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getDescription() {
     return description;
  }

  public int getCode() {
     return code;
  }
  public static ErrorEnumDemo getDemoByCode(int code) {
      for (ErrorEnumDemo errorEnumDemo : ErrorEnumDemo.values()) {  
          if (errorEnumDemo.getCode() == code) {  
              return errorEnumDemo;  
          }  
      }  
      return null;  
  } 
  @Override
  public String toString() {
    return code + ": " + description;
  }
}