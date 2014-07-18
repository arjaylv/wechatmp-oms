package com.sftxy.wechatmp.irs.resolver;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.TextMessage;

@Component
public class DefaultResolver extends ResolverAdapter<Message> {

    @Override
    public Message resolve(Message input) {
        return new TextMessage(input, "Welcome from DefaultResolver!");
    }

}
