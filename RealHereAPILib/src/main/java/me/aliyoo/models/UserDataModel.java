/*
 * RealHereAPILib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ) on 05/26/2016
 */
package me.aliyoo.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class UserDataModel 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = 4799617612854271707L;
    private String comAddr = "X-Address";
    private String email = "example@123.com";
    private String pwd = "12345678";
    private String userCom = "X-Company";
    private int userID = 1111;
    private String userName = "X-Man";
    private String userNote = "Ta啥都没说";
    private Integer userTel;
    /** GETTER
     * 组织地址
     */
    @JsonGetter("comAddr")
    public String getComAddr ( ) { 
        return this.comAddr;
    }
    
    /** SETTER
     * 组织地址
     */
    @JsonSetter("comAddr")
    public void setComAddr (String value) { 
        this.comAddr = value;
        notifyObservers(this.comAddr);
    }
 
    /** GETTER
     * 用户邮箱
     */
    @JsonGetter("email")
    public String getEmail ( ) { 
        return this.email;
    }
    
    /** SETTER
     * 用户邮箱
     */
    @JsonSetter("email")
    public void setEmail (String value) { 
        this.email = value;
        notifyObservers(this.email);
    }
 
    /** GETTER
     * 用户密码
     */
    @JsonGetter("pwd")
    public String getPwd ( ) { 
        return this.pwd;
    }
    
    /** SETTER
     * 用户密码
     */
    @JsonSetter("pwd")
    public void setPwd (String value) { 
        this.pwd = value;
        notifyObservers(this.pwd);
    }
 
    /** GETTER
     * 用户所属组织
     */
    @JsonGetter("userCom")
    public String getUserCom ( ) { 
        return this.userCom;
    }
    
    /** SETTER
     * 用户所属组织
     */
    @JsonSetter("userCom")
    public void setUserCom (String value) { 
        this.userCom = value;
        notifyObservers(this.userCom);
    }
 
    /** GETTER
     * 系统分配用户ID
     */
    @JsonGetter("userID")
    public int getUserID ( ) { 
        return this.userID;
    }
    
    /** SETTER
     * 系统分配用户ID
     */
    @JsonSetter("userID")
    public void setUserID (int value) { 
        this.userID = value;
        notifyObservers(this.userID);
    }
 
    /** GETTER
     * 用户姓名
     */
    @JsonGetter("userName")
    public String getUserName ( ) { 
        return this.userName;
    }
    
    /** SETTER
     * 用户姓名
     */
    @JsonSetter("userName")
    public void setUserName (String value) { 
        this.userName = value;
        notifyObservers(this.userName);
    }
 
    /** GETTER
     * 个人备注
     */
    @JsonGetter("userNote")
    public String getUserNote ( ) { 
        return this.userNote;
    }
    
    /** SETTER
     * 个人备注
     */
    @JsonSetter("userNote")
    public void setUserNote (String value) { 
        this.userNote = value;
        notifyObservers(this.userNote);
    }
 
    /** GETTER
     * 用户电话
     */
    @JsonGetter("userTel")
    public Integer getUserTel ( ) { 
        return this.userTel;
    }
    
    /** SETTER
     * 用户电话
     */
    @JsonSetter("userTel")
    public void setUserTel (Integer value) { 
        this.userTel = value;
        notifyObservers(this.userTel);
    }
 
}
 