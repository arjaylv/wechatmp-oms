package com.sftxy.wechatmp.irs.processor;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.processor.Processor;
import com.sftxy.wechatmp.framework.resolver.Resolver;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.event.EventMessage;

@Component
public class EventProcessor implements Processor<EventMessage> {

    @Resource(name = "eventResolvers")
    private Map<String, Resolver<? extends EventMessage>> eventResolvers;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Message process(EventMessage input) {
        String event = input.getEvent();
        Resolver resolver = eventResolvers.get(event);
        if (null != resolver) {
            return resolver.resolve(input);
        } else {
            return null;
        }
    }

}
