package com.sftxy.wechatmp.framework.resolver;

import java.util.ArrayList;
import java.util.List;

import com.sftxy.wechatmp.sdk.model.message.Message;

public abstract class ResolverAdapter<T extends Message> implements Resolver<T> {

    @Override
    public void addResolver(Resolver<T> resolver) {}

    @Override
    public List<Resolver<T>> listResolvers() {
        return new ArrayList<Resolver<T>>(1);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}