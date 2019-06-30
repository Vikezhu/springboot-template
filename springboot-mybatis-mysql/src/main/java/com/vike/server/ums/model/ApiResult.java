package com.vike.server.ums.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * API返回结果的通用格式
 */
@ApiModel(description = "API返回结果的通用格式")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-19T11:45:28.038+08:00")

public class ApiResult   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("datas")
  private Object datas = null;

  public ApiResult(){}

  public ApiResult code(String code) {
    this.code = code;
    return this;
  }

  /**
   * 请求的返回码
   * @return code
  **/
  @ApiModelProperty(value = "请求的返回码")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ApiResult message(String message) {
    this.message = message;
    return this;
  }

  /**
   * 请求的返回消息
   * @return message
  **/
  @ApiModelProperty(value = "请求的返回消息")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ApiResult count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * 返回数据的条数
   * @return count
  **/
  @ApiModelProperty(value = "返回数据的条数")


  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public ApiResult datas(Object datas) {
    this.datas = datas;
    return this;
  }

  /**
   * 返回的数据
   * @return datas
  **/
  @ApiModelProperty(value = "返回的数据")


  public Object getDatas() {
    return datas;
  }

  public void setDatas(Object datas) {
    this.datas = datas;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiResult apiResult = (ApiResult) o;
    return Objects.equals(this.code, apiResult.code) &&
        Objects.equals(this.message, apiResult.message) &&
        Objects.equals(this.count, apiResult.count) &&
        Objects.equals(this.datas, apiResult.datas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, count, datas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiResult {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    datas: ").append(toIndentedString(datas)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

