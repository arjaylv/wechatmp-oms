package com.sftxy.wechatmp.sdk.model.message.event;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.w3c.dom.Document;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.util.XMLUtil;

public class EventMessage extends Message {

    private static final long serialVersionUID = 944396579755348614L;

    private String event;

    public EventMessage() {
        this.setMessageType(Constants.MESSAGE_TYPE_EVENT);
    }

    public EventMessage(Document document) {
        super(document);
        event = XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT);
    }

    @Override
    @Deprecated
    @JsonIgnore
    public String getMessageId() {
        throw new UnsupportedOperationException("Event Message do not has message id");
    }

    @Override
    @Deprecated
    @JsonIgnore
    public void setMessageId(String messageId) {
        throw new UnsupportedOperationException("Event Message do not has message id");
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
