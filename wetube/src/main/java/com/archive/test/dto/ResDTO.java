package com.archive.test.dto;


import lombok.Generated;

public class ResDTO<T> {
  private Integer code;
  
  private String message;
  
  private T data;
  
  @Generated
  public Integer getCode() {
    return this.code;
  }
  
  @Generated
  public String getMessage() {
    return this.message;
  }
  
  @Generated
  public T getData() {
    return this.data;
  }
  
  @Generated
  public ResDTO() {}
  
  @Generated
  public ResDTO(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }
  
  @Generated
  public static <T> ResDTOBuilder<T> builder() {
    return new ResDTOBuilder();
  }
}

