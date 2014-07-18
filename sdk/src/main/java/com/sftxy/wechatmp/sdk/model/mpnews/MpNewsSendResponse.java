package com.sftxy.wechatmp.sdk.model.mpnews;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sftxy.wechatmp.sdk.model.ErrorResponse;

public class MpNewsSendResponse extends ErrorResponse {

    @JsonProperty("msg_id")
    private long msgId;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

}
