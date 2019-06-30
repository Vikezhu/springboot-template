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
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-19T11:45:28.038+08:00")

public class User   {
  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("phone")
  private String phone = null;

  public User userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * 用户ID
   * @return userId
  **/
  @ApiModelProperty(value = "用户ID")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 用户名
   * @return name
  **/
  @ApiModelProperty(value = "用户名")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User code(String code) {
    this.code = code;
    return this;
  }

  /**
   * 工号
   * @return code
  **/
  @ApiModelProperty(value = "工号")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public User phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * 电话
   * @return phone
  **/
  @ApiModelProperty(value = "电话")


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userId, user.userId) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.code, user.code) &&
        Objects.equals(this.phone, user.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, code, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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

