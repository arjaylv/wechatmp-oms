package com.sftxy.wechatmp.irs.resolver.event;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.TextMessage;
import com.sftxy.wechatmp.sdk.model.message.event.EventMessage;

@Component
public class SubscribeResolver extends ResolverAdapter<EventMessage> {

    @Override
    public Message resolve(EventMessage input) {
        String openId = input.getFromUserName();
        return new TextMessage(input, openId + " subscribed!");
    }
}
