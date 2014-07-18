package com.sftxy.wechatmp.framework.processor;

import com.sftxy.wechatmp.sdk.model.message.Message;


public interface Processor<T extends Message> {
    Message process(T input);
}