package com.sftxy.wechatmp.irs.resolver.event;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.event.LocationEventMessage;

@Component
public class EventLocationResolver extends ResolverAdapter<LocationEventMessage> {

    @Override
    public Message resolve(LocationEventMessage input) {
        return null;
    }
}
