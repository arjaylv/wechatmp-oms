package com.sftxy.wechatmp.sdk.model.message.event;

import org.w3c.dom.Document;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.util.XMLUtil;

public class ViewEventMessage extends EventMessage {

    private static final long serialVersionUID = -2861397632478497067L;

    private String eventKey;

    public ViewEventMessage() {
        super();
    }

    public ViewEventMessage(Document document) {
        super(document);
        eventKey = XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_KEY);
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

}
