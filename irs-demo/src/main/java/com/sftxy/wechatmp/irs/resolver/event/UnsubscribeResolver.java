package com.sftxy.wechatmp.irs.resolver.event;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.event.EventMessage;

@Component("unsubscribeResolver")
public class UnsubscribeResolver extends ResolverAdapter<EventMessage> {

    @Override
    public Message resolve(EventMessage input) {
        return null;
    }
}
