package com.archive.test.dto;


import com.archive.test.dto.ResDTO;
import lombok.Generated;

@Generated
public class ResDTOBuilder<T> {
  @Generated
  private Integer code;
  
  @Generated
  private String message;
  
  @Generated
  private T data;
  
  @Generated
  public ResDTOBuilder<T> code(Integer code) {
    this.code = code;
    return this;
  }
  
  @Generated
  public ResDTOBuilder<T> message(String message) {
    this.message = message;
    return this;
  }
  
  @Generated
  public ResDTOBuilder<T> data(T data) {
    this.data = data;
    return this;
  }
  
  @Generated
  public ResDTO<T> build() {
    return new ResDTO(this.code, this.message, this.data);
  }
  
  @Generated
  public String toString() {
    return "ResDTO.ResDTOBuilder(code=" + String.valueOf(this.code) + ", message=" + this.message + ", data=" + String.valueOf(this.data) + ")";
  }
}
