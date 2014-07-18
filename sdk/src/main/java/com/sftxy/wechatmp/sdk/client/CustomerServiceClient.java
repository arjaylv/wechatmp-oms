package com.sftxy.wechatmp.sdk.client;

import java.util.HashMap;
import java.util.Map;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.model.Authorization;
import com.sftxy.wechatmp.sdk.model.message.Message;
import com.sftxy.wechatmp.sdk.util.PropertiesUtil;
import com.sftxy.wechatmp.sdk.util.RequestUtil;

public class CustomerServiceClient extends BaseClient {

    /**
     * this method can be called since a follower send message to wechat account within 24 h
     * @param message
     * @return String
     */
    public String replyMessage(Authorization authorization, Message message) {
        String url = PropertiesUtil.getAPI(Constants.API_CUSTOMER_SERVICE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(url, params, message.toJSON());
        return result;
    }

}
