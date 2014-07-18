package com.sftxy.wechatmp.irs.resolver.text;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.TextMessage;

@Component
public class KeywordResolver extends ResolverAdapter<TextMessage> {

    @Override
    public Message resolve(TextMessage input) {
        return new TextMessage(input, String.format("Your input is %s", input.getContent()));
    }
}
