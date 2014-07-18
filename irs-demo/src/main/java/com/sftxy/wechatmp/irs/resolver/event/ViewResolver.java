package com.sftxy.wechatmp.irs.resolver.event;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.event.ViewEventMessage;

@Component
public class ViewResolver extends ResolverAdapter<ViewEventMessage> {

    @Override
    public Message resolve(ViewEventMessage input) {
        return null;
    }
}
