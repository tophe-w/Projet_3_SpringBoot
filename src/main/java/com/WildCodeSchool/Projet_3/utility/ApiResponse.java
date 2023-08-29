package com.WildCodeSchool.Projet_3.utility;


public class ApiResponse<T> {
  private T data;
  private String error;

  public ApiResponse(T data) {
    this.data = data;
    this.error = null;
  }

  public ApiResponse(String error) {
    this.error = error;
    this.data = null;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

}