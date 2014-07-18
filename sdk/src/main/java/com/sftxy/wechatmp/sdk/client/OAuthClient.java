package com.sftxy.wechatmp.sdk.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.model.Authorization;
import com.sftxy.wechatmp.sdk.util.JSONUtil;
import com.sftxy.wechatmp.sdk.util.PropertiesUtil;
import com.sftxy.wechatmp.sdk.util.RequestUtil;

public class OAuthClient {

    private Logger logger = Logger.getLogger(OAuthClient.class);

    /**
     * get the access token, the refresh method is the same
     * @return Authorization
     */
    public Authorization requestAuthorization(String appId, String appSecret) {
        String accessTokenAPI = PropertiesUtil.getAPI(Constants.API_ACCESS_TOKEN);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_APP_ID, appId);
        params.put(Constants.ARG_APP_SECRET, appSecret);
        String result = RequestUtil.doGet(accessTokenAPI, params);
        logger.info(result);
        return wrapAuthorization(result);
    }

    private Authorization wrapAuthorization(String result) {
        Map<String, Object> accessTokenMap = JSONUtil.jsonStr2Map(result);
        String accessToken = (String) accessTokenMap.get(Constants.ARG_ACCESS_TOKEN);
        int expiredTime = (Integer) accessTokenMap.get(Constants.ARG_EXPIRES_IN);
        Authorization access = new Authorization(accessToken, expiredTime);
        return access;
    }
}
