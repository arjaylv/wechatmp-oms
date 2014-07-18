package com.sftxy.wechatmp.sdk.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.exception.WechatSDKException;
import com.sftxy.wechatmp.sdk.model.Authorization;
import com.sftxy.wechatmp.sdk.model.menu.Button;
import com.sftxy.wechatmp.sdk.util.JSONUtil;
import com.sftxy.wechatmp.sdk.util.PropertiesUtil;
import com.sftxy.wechatmp.sdk.util.RequestUtil;

public class MenuClient extends BaseClient {

    /**
     *
     * @param buttonList
     * @param accessToken
     * @return {"errcode":0,"errmsg":"ok"}, {"errcode":40018,"errmsg":"invalid button name size"}
     */
    public String createMenu(Authorization authorization, List<Button> buttonList) {
        Map<String, Object> menu = new HashMap<String, Object>();
        menu.put(Constants.ARG_MENU_BUTTON, buttonList);
        String menuJson = JSONUtil.Map2JsonStr(menu);
        String createMenuApi = PropertiesUtil.getAPI(Constants.API_MENU_CREATE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(createMenuApi, params, menuJson);
        return result;
    }

    /**
     * get memu json info
     * @return
     */
    public String getMenu(Authorization authorization) throws WechatSDKException {
        String getMenuApi = PropertiesUtil.getAPI(Constants.API_MENU_GET);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String menuJson = RequestUtil.doGet(getMenuApi, params);
        return menuJson;
    }

    /**
     *
     * @param accessToken
     * @return {"errcode":0,"errmsg":"ok"}
     */
    public String deleteMenu(Authorization authorization) {
        String getMenuApi = PropertiesUtil.getAPI(Constants.API_MENU_DELETE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doGet(getMenuApi, params);
        return result;
    }
}
