package com.sftxy.wechatmp.irs.processor;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.processor.Processor;
import com.sftxy.wechatmp.framework.resolver.Resolver;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.TextMessage;

@Component
public class TextProcessor implements Processor<TextMessage> {

    @Resource(name = "textResolverChain")
    private Resolver<TextMessage> resolver;

    @Override
    public Message process(TextMessage input) {
        return resolver.resolve(input);
    }
}
