package com.sftxy.wechatmp.sdk.client;

import java.util.HashMap;
import java.util.Map;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.exception.WechatSDKException;
import com.sftxy.wechatmp.sdk.model.Authorization;
import com.sftxy.wechatmp.sdk.model.Follower;
import com.sftxy.wechatmp.sdk.model.FollowerContainer;
import com.sftxy.wechatmp.sdk.util.PropertiesUtil;
import com.sftxy.wechatmp.sdk.util.RequestUtil;

public class FollowerClient extends BaseClient {

    /**
     * get follower openId list, the pagination is 10,000
     * @param nextOpenId: optional
     * @return FollowerContainer
     * @throws WechatSDKException
     */
    public FollowerContainer getFollowerList(Authorization authorization, String... nextOpenId) throws WechatSDKException {
        String getFollowerListAPI = PropertiesUtil.getAPI(Constants.API_FOLOOLWER_LIST);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        if (nextOpenId.length > 0) {
            params.put(Constants.ARG_NEXT_OPENID, nextOpenId[0]);
        }
        String result = RequestUtil.doGet(getFollowerListAPI, params);
        FollowerContainer followerContainer = this.wrapModel(result, FollowerContainer.class);
        return followerContainer;
    }

    /**
     * get follower info by its openId
     * @param openId
     * @return Follower
     * @throws WechatSDKException
     */
    public Follower getFollowerInfo(Authorization authorization, String openId) throws WechatSDKException {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        params.put(Constants.ARG_OPENID, openId);
        String getFollowerInfoAPI = PropertiesUtil.getAPI(Constants.API_FOLOOLWER_INFO);
        String result = RequestUtil.doGet(getFollowerInfoAPI, params);
        Follower follower = this.wrapModel(result, Follower.class);
        return follower;
    }

}
