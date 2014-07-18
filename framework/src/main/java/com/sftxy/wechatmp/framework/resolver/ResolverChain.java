package com.sftxy.wechatmp.framework.resolver;

import java.util.ArrayList;
import java.util.List;

import com.sftxy.wechatmp.sdk.model.message.Message;

public class ResolverChain<T extends Message> implements Resolver<T> {

    private final List<Resolver<T>> resolverList;

    public ResolverChain() {
        this.resolverList = new ArrayList<Resolver<T>>();
    }

    public ResolverChain(List<Resolver<T>> resolverList) {
        this.resolverList = resolverList;
    }

    @Override
    public Message resolve(T input) {
        Message response = null;
        if (!resolverList.isEmpty()) {
            for (Resolver<T> resolver : resolverList) {
                response = resolver.resolve(input);
                if (null != response) {
                    return response;
                }
            }
        }
        return response;
    }

    @Override
    public void addResolver(Resolver<T> resolver) {
        resolverList.add(resolver);
    }

    @Override
    public List<Resolver<T>> listResolvers() {
        return resolverList;
    }

    @Override
    public String toString() {
        return resolverList.toString();
    }
}