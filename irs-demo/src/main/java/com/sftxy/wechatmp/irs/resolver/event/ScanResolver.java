package com.sftxy.wechatmp.irs.resolver.event;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.TextMessage;
import com.sftxy.wechatmp.sdk.model.message.event.ScanEventMessage;

@Component
public class ScanResolver extends ResolverAdapter<ScanEventMessage> {

    @Override
    public Message resolve(ScanEventMessage input) {
        String eventKey = input.getEventKey();
        String ticket = input.getTicket();
        return new TextMessage(input, String.format("Scanned eventKey: %s, tikcet: %s", eventKey, ticket));
    }
}
