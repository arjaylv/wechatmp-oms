package com.sftxy.wechatmp.sdk.client;

import com.sftxy.wechatmp.sdk.exception.WechatSDKException;
import com.sftxy.wechatmp.sdk.util.JSONUtil;

public abstract class BaseClient {

    protected <T> T wrapModel(String result, Class<T> clazz) throws WechatSDKException {
        T model = JSONUtil.JsonStr2Model(result, clazz);
        if (null == model) {
            throw new WechatSDKException(result);
        } else {
            return model;
        }
    }
}
