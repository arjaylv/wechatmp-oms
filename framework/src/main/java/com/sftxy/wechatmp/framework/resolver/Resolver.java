package com.sftxy.wechatmp.framework.resolver;

import java.util.List;

import com.sftxy.wechatmp.sdk.model.message.Message;

public interface Resolver<T extends Message> {

    Message resolve(T input);

    void addResolver(Resolver<T> resolver);

    List<Resolver<T>> listResolvers();
}