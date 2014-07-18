package com.sftxy.wechatmp.sdk.client;

import java.util.HashMap;
import java.util.Map;

import com.sftxy.wechatmp.sdk.constants.Constants;
import com.sftxy.wechatmp.sdk.exception.WechatSDKException;
import com.sftxy.wechatmp.sdk.model.Authorization;
import com.sftxy.wechatmp.sdk.model.Group;
import com.sftxy.wechatmp.sdk.model.GroupContainer;
import com.sftxy.wechatmp.sdk.util.JSONUtil;
import com.sftxy.wechatmp.sdk.util.PropertiesUtil;
import com.sftxy.wechatmp.sdk.util.RequestUtil;

public class GroupClient extends BaseClient {

    /**
     * create a group
     * @param group: the name property is required in group model
     * @return group
     * @throws WechatSDKException
     */
    @SuppressWarnings("unchecked")
    public Group createGroup(Authorization authorization, Group group) throws WechatSDKException {
        String createGroupAPI = PropertiesUtil.getAPI(Constants.API_GROUP_CREATE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(createGroupAPI, params, group.toCreateString());
        Map<String, Object> groupMap = (Map<String, Object>) JSONUtil.jsonStr2Map(result).get(Constants.ARG_GROUP);
        result = JSONUtil.Map2JsonStr(groupMap);
        group = this.wrapModel(result, Group.class);
        return group;
    }

    /**
     * get group list of the account
     * @return GroupContainer
     * @throws WechatSDKException
     */
    public GroupContainer getGroup(Authorization authorization) throws WechatSDKException {
        String getGroupAPI = PropertiesUtil.getAPI(Constants.API_GROUP_GET);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doGet(getGroupAPI, params);
        GroupContainer groups = this.wrapModel(result, GroupContainer.class);
        return groups;
    }

    /**
     * rename a group
     * @param group: the id and name properties are required in group model
     * @return {"errcode":0,"errmsg":"ok"}
     */
    public String renameGroup(Authorization authorization, Group group) { // TODO return
        String renameGroupAPI = PropertiesUtil.getAPI(Constants.API_GROUP_UPDATE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(renameGroupAPI, params, group.toUpdateString());
        return result;
    }

    /**
     * move one user to another group
     * @param openId
     * @param groupId
     * @return {"errcode":0,"errmsg":"ok"}
     */
    public String moveUserTo(Authorization authorization, String openId, int groupId) { // TODO return
        String moveUserGroupAPI = PropertiesUtil.getAPI(Constants.API_GROUP_MOVE_USER);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(Constants.ARG_OPENID, openId);
        jsonMap.put(Constants.ARG_TO_GROUP_ID, groupId);
        String jsonStr = JSONUtil.Map2JsonStr(jsonMap);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(moveUserGroupAPI, params, jsonStr);
        return result;
    }

}
