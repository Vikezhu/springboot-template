package com.vike.server.ums.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * UserDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-19T11:45:28.038+08:00")

@Document(collection = "ums")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 2368696278547315954L;

    @Id
    @JsonProperty("userId")
    private String userId = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("age")
    private Integer age = null;

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("phone")
    private String phone = null;

    @JsonProperty("apartment")
    private String apartment = null;

    @JsonProperty("bizLine")
    private String bizLine = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("entryTime")
    private String entryTime = null;

    @JsonProperty("status")
    private Integer status = null;

    @JsonProperty("skill")
    private List<String> skill = null;

    public UserDetails userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 用户ID
     *
     * @return userId
     **/
    @ApiModelProperty(value = "用户ID")


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDetails name(String name) {
        this.name = name;
        return this;
    }

    /**
     * 用户名
     *
     * @return name
     **/
    @ApiModelProperty(value = "用户名")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDetails age(Integer age) {
        this.age = age;
        return this;
    }

    /**
     * 年龄
     *
     * @return age
     **/
    @ApiModelProperty(value = "年龄")


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserDetails code(String code) {
        this.code = code;
        return this;
    }

    /**
     * 工号
     *
     * @return code
     **/
    @ApiModelProperty(value = "工号")


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserDetails phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * 电话
     *
     * @return phone
     **/
    @ApiModelProperty(value = "电话")


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserDetails apartment(String apartment) {
        this.apartment = apartment;
        return this;
    }

    /**
     * 部门
     *
     * @return apartment
     **/
    @ApiModelProperty(value = "部门")


    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public UserDetails bizLine(String bizLine) {
        this.bizLine = bizLine;
        return this;
    }

    /**
     * 业务线
     *
     * @return bizLine
     **/
    @ApiModelProperty(value = "业务线")


    public String getBizLine() {
        return bizLine;
    }

    public void setBizLine(String bizLine) {
        this.bizLine = bizLine;
    }

    public UserDetails email(String email) {
        this.email = email;
        return this;
    }

    /**
     * 邮箱
     *
     * @return email
     **/
    @ApiModelProperty(value = "邮箱")


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails entryTime(String entryTime) {
        this.entryTime = entryTime;
        return this;
    }

    /**
     * 入职时间
     *
     * @return entryTime
     **/
    @ApiModelProperty(value = "入职时间")

    @Valid

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public UserDetails status(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * 状态：1=在岗&2=离职中&2=已离职
     *
     * @return status
     **/
    @ApiModelProperty(value = "状态：1=在岗&2=离职中&2=已离职")


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserDetails skill(List<String> skill) {
        this.skill = skill;
        return this;
    }

    /**
     * 技能
     *
     * @return skill
     **/
    @ApiModelProperty(value = "技能")


    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDetails userDetails = (UserDetails) o;
        return Objects.equals(this.userId, userDetails.userId) &&
                Objects.equals(this.name, userDetails.name) &&
                Objects.equals(this.age, userDetails.age) &&
                Objects.equals(this.code, userDetails.code) &&
                Objects.equals(this.phone, userDetails.phone) &&
                Objects.equals(this.apartment, userDetails.apartment) &&
                Objects.equals(this.bizLine, userDetails.bizLine) &&
                Objects.equals(this.email, userDetails.email) &&
                Objects.equals(this.entryTime, userDetails.entryTime) &&
                Objects.equals(this.status, userDetails.status) &&
                Objects.equals(this.skill, userDetails.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, age, code, phone, apartment, bizLine, email, entryTime, status, skill);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserDetails {\n");

        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    age: ").append(toIndentedString(age)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    apartment: ").append(toIndentedString(apartment)).append("\n");
        sb.append("    bizLine: ").append(toIndentedString(bizLine)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    entryTime: ").append(toIndentedString(entryTime)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    skill: ").append(toIndentedString(skill)).append("\n");
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

