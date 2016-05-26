/*
 * RealHereAPILib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ) on 05/26/2016
 */
package me.aliyoo.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TestRetModel 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = 5160762449968079647L;
    private String errMsg;
    private int errNum;
    private List<TestRetDataModel> retData;
    /** GETTER
     * 错误信息
     */
    @JsonGetter("errMsg")
    public String getErrMsg ( ) { 
        return this.errMsg;
    }
    
    /** SETTER
     * 错误信息
     */
    @JsonSetter("errMsg")
    public void setErrMsg (String value) { 
        this.errMsg = value;
        notifyObservers(this.errMsg);
    }
 
    /** GETTER
     * 错误码
     */
    @JsonGetter("errNum")
    public int getErrNum ( ) { 
        return this.errNum;
    }
    
    /** SETTER
     * 错误码
     */
    @JsonSetter("errNum")
    public void setErrNum (int value) { 
        this.errNum = value;
        notifyObservers(this.errNum);
    }
 
    /** GETTER
     * 响应信息正文
     */
    @JsonGetter("retData")
    public List<TestRetDataModel> getRetData ( ) { 
        return this.retData;
    }
    
    /** SETTER
     * 响应信息正文
     */
    @JsonSetter("retData")
    public void setRetData (List<TestRetDataModel> value) { 
        this.retData = value;
        notifyObservers(this.retData);
    }
 
}
 