package com.sftxy.wechatmp.sdk.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class ErrorResponse {
    @JsonProperty("errcode")
    private short errorCode;
    @JsonProperty("errmsg")
    private String errorMsg;

    public short getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(short errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
