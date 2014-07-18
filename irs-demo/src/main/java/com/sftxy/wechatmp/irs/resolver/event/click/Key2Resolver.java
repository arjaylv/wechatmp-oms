package com.sftxy.wechatmp.irs.resolver.event.click;

import org.springframework.stereotype.Component;

import com.sftxy.wechatmp.framework.resolver.ResolverAdapter;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.model.message.event.ClickEventMessage;

@Component
public class Key2Resolver extends ResolverAdapter<ClickEventMessage> {

    @Override
    public Message resolve(ClickEventMessage input) {
        // TODO Auto-generated method stub
        return null;
    }

}
