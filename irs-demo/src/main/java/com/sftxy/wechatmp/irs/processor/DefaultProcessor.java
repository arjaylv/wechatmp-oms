package com.sftxy.wechatmp.irs.processor;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.processor.Processor;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.TextMessage;

@Component
public class DefaultProcessor<T extends Message> implements Processor<T> {

    @Override
    public Message process(T input) {
        return new TextMessage(input, "Welcome from DefaultProcessor!");
    }

}
