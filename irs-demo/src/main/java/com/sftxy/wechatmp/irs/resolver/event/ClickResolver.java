package com.sftxy.wechatmp.irs.resolver.event;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.Resolver;
import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.event.ClickEventMessage;

@Component
public class ClickResolver extends ResolverAdapter<ClickEventMessage> {

    @Resource(name = "clickResovers")
    private Map<String, Resolver<ClickEventMessage>> clickResovers;

    @Override
    public Message resolve(ClickEventMessage input) {
        String eventKey = input.getEventKey();
        Resolver<ClickEventMessage> resolver = clickResovers.get(eventKey);
        if (null != resolver) {
           return resolver.resolve(input);
        }
        return null;
    }
}
