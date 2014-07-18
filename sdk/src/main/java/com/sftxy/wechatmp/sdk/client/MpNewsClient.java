package com.sftxy.wechatmp.sdk.client;

import java.util.HashMap;
import java.util.Map;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.exception.WechatSDKException;
import com.sftxy.wechatmp.sdk.model.Authorization;
import com.sftxy.wechatmp.sdk.model.ErrorResponse;
import com.sftxy.wechatmp.sdk.model.Media;
import com.sftxy.wechatmp.sdk.model.mpnews.MpNews;
import com.sftxy.wechatmp.sdk.model.mpnews.MpNewsGroupArg;
import com.sftxy.wechatmp.sdk.model.mpnews.MpNewsOidsArg;
import com.sftxy.wechatmp.sdk.model.mpnews.MpNewsSendResponse;
import com.sftxy.wechatmp.sdk.util.PropertiesUtil;
import com.sftxy.wechatmp.sdk.util.RequestUtil;

public class MpNewsClient extends BaseClient {

    public Media createMpNews(Authorization authorization, MpNews mpNews) throws WechatSDKException {
        String createMpNewsAPI = PropertiesUtil.getAPI(Constants.API_MPNEWS_CREATE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(createMpNewsAPI, params, mpNews.toJSON());
        Media media = this.wrapModel(result, Media.class);
        return media;
    }

    /**
     * 
     * @param groupArg
     * @return {"errcode":0,"errmsg":"send job submission success","msg_id":34182}
     * @throws WechatSDKException 
     */
    public MpNewsSendResponse groupSendMpNews(Authorization authorization, MpNewsGroupArg groupArg) throws WechatSDKException {
        String groupSendAPI = PropertiesUtil.getAPI(Constants.API_MPNEWS_GROUP_SEND);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(groupSendAPI, params, groupArg.toJSON());
        MpNewsSendResponse response = this.wrapModel(result, MpNewsSendResponse.class);
        return response;
    }

    /**
     * 
     * @param oidsArg
     * @return {"errcode":0,"errmsg":"send job submission success","msg_id":34182}
     * @throws WechatSDKException 
     */
    public MpNewsSendResponse oidsSendMpNews(Authorization authorization, MpNewsOidsArg oidsArg) throws WechatSDKException {
        String oidsSendAPI = PropertiesUtil.getAPI(Constants.API_MPNEWS_OIDS_SEND);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(oidsSendAPI, params, oidsArg.toJSON());
        MpNewsSendResponse response = this.wrapModel(result, MpNewsSendResponse.class);
        return response;
    }

    public ErrorResponse deleteMpNews(Authorization authorization, long msgId) throws WechatSDKException {
        String jsonStr = 
                "{\n" +
                "\"msg_id\":%d\n" +
                "}";
        String oidsSendAPI = PropertiesUtil.getAPI(Constants.API_MPNEWS_DELETE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(oidsSendAPI, params, String.format(jsonStr, msgId));
        ErrorResponse response= this.wrapModel(result, ErrorResponse.class);
        return response;
    }
}
