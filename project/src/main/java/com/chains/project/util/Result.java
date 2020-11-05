package com.chains.project.util;

import java.io.Serializable;

/**
 * @author
 * @param <T>
 */
public class Result<T> implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  /**
   * 状态码
   */
  private String code;

  /**
   * 状态
   */
  private Boolean success;

  /**
   * 提示消息
   */
  private String msg;

  /**
   * 提示消息
   */
  private Long count;

  /**
   * 数据对象
   */
  private T data;

  /**
   * 无参构造器
   */
  private Result() {
    super();
  }

  /**
   * 只返回状态，状态码，消息
   * 
   * @param success
   * @param code
   * @param msg
   */
  private Result(Boolean success, String code, String msg) {
    super();
    this.success = success;
    this.code = code;
    this.msg = msg;
  }

  /**
   * 只返回状态，状态码，数据对象
   * 
   * @param success
   * @param code
   * @param data
   */
  private Result(Boolean success, String code, T data) {
    super();
    this.success = success;
    this.code = code;
    this.data = data;
  }

  /**
   * 返回全部信息即状态，状态码，消息，数据对象
   * 
   * @param success
   * @param code
   * @param msg
   * @param data
   */
  private Result(Boolean success, String code, String msg, T data) {
    super();
    this.success = success;
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  /**
   * 返回全部信息即状态，状态码，消息，数据条数，数据对象，
   *
   * @param success
   * @param code
   * @param msg
   * @param count
   * @param data
   */
  private Result(Boolean success, String code, String msg,Long count, T data) {
    super();
    this.success = success;
    this.code = code;
    this.msg = msg;
    this.count = count;
    this.data = data;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Long getCount(){
    return count;
  }

  public void setCount(){
    this.count = count;
  }

  public Object getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static <T> Result<T> success(String code, String msg,Long count, T data) {
    return new Result<T>(true, code, msg, count,data);
  }

  public static <T> Result<T> success(String msg,Long count, T data) {
    return success(ResultCodeEnum.DEFAULT_SUCCESS_CODE.getCode(), msg,count, data);
  }


  public static <T> Result<T> success(Long count,T data) {
    return success(ResultCodeEnum.DEFAULT_SUCCESS_CODE,count, data);
  }

  public static <T> Result<T> success(ResultCodeEnum codeEnum,Long count,T data) {
    return success(codeEnum.getCode(), codeEnum.getMsg(), count ,data);
  }
  
  public static Result<?> success(String msg) {
    return success(msg, null,null);
  }
  public static Result<?> success() {
    return success(ResultCodeEnum.DEFAULT_SUCCESS_CODE, null,null);
  }

  
  public static Result<?> error(String code, String msg) {
    return new Result<>(false, code, msg);
  }
  
  public static Result<?> error(String msg) {
    return error(ResultCodeEnum.DEFAULT_FAILURE_CODE.getCode(), msg);
  }

  public static Result<?> error(ResultCodeEnum codeEnum) {
    return error(codeEnum.getCode(), codeEnum.getMsg());
  }

  @Override
  public String toString() {
    return "Result{" +
        "code='" + code + '\'' +
        ", success=" + success +
        ", msg='" + msg + '\'' +
        ", data=" + data +
        '}';
  }
}
